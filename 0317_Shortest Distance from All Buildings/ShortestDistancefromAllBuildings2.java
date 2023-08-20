class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distances = new int[m][n];
        // How frequently has it been updated through traversing buildings. An update at updatedTime[i][j] is considered invalid if it's less than the count of buildings, 
        // indicating that not all buildings can reach this point.
        int[][] updatedTime = new int[m][n];
        // the list of buildings
        List<int[]> buildings = new ArrayList<>();
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1)  buildings.add(new int[]{i,j});
            }
        }

        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        for(int[] building : buildings) {
            int[][] currDist = new int[m][n];
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    currDist[i][j] = Integer.MAX_VALUE;
                }
            }
            // track the distance from the building
            currDist[building[0]][building[1]] = 0;
            Queue<int[]> q = new LinkedList<>();
            q.offer(building);
            boolean[][] visited = new boolean[m][n];
            while(q.size() > 0) {
                int size = q.size();
                while(size-->0) {
                    int[] arr = q.poll();
                    int x = arr[0], y = arr[1];
                    for(int i=0;i<dirs.length;i++) {
                        int dx = x + dirs[i][0];
                        int dy = y + dirs[i][1];
                        if(dx < 0 || dy < 0 || dx == m || dy == n || grid[dx][dy] > 0 || visited[dx][dy] ) continue;
                        visited[dx][dy] = true;
                        currDist[dx][dy] = Math.min(currDist[dx][dy], currDist[x][y] + 1);
                        q.offer(new int[]{dx,dy});
                    }
                }
            }

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j] == 0) {
                        if(currDist[i][j] != Integer.MAX_VALUE) {
                            distances[i][j] += currDist[i][j];
                            updatedTime[i][j]++;
                        }
                    }
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0 && updatedTime[i][j] >= buildings.size()) {
                    ans = Math.min(ans, distances[i][j]);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}