class Solution {
    public int shortestDistance(int[][] grid) {
        int[] dirs = new int[]{0,1,0,-1,0};
        int m = grid.length, n = grid[0].length;
        int[][] reachCount = new int[m][n];
        int[][] dist = new int[m][n];
        
        int totalBuildings = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    totalBuildings++;
                    //return false if not all building reached.
                    if(!BFS(grid, i, j, reachCount, dist, dirs)) return -1;
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachCount[i][j] == totalBuildings && dist[i][j] < ans) {
                    ans = dist[i][j];
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private boolean BFS(int[][] grid, int x, int y, int[][] reachCount, int[][] dist, int[] dirs) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int d = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            d++;
            while(size-- > 0) {
                int[] curr = queue.poll();
                
                for(int i=0;i<4;i++) {
                    int dx = curr[0] + dirs[i];
                    int dy = curr[1] + dirs[i+1];
                    
                    if(dx < 0 || dy < 0 || dx == m || dy == n || grid[dx][dy] == 2 || visited[dx][dy]) continue;
                    
                    if(grid[dx][dy] == 0) {
                        queue.add(new int[]{dx, dy});
                        reachCount[dx][dy]++;
                        dist[dx][dy] += d;
                    }
                    
                    visited[dx][dy] = true;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}