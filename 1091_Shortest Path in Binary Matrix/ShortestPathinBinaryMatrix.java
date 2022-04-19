class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[8][];
        dirs[0] = new int[] {-1, 1};
        dirs[1] = new int[] {-1, 0};
        dirs[2] = new int[] {-1,-1};
        dirs[3] = new int[] {0,  1};
        dirs[4] = new int[] {0, -1};
        dirs[5] = new int[] {1, -1};
        dirs[6] = new int[] {1,  0};
        dirs[7] = new int[] {1,  1};
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;
        
        int ans = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            ans++;
            while(size-- > 0) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];    
                if(x+1 == m && y+1 == n) return ans;
                
                for(int i=0;i< dirs.length;i++) {
                    int dx = dirs[i][0] + x;
                    int dy = dirs[i][1] + y;
                    if(dx < 0 || dy < 0 || dx == m || dy == n || grid[dx][dy] != 0) continue;
                    queue.offer(new int[]{dx, dy});
                    grid[dx][dy] = 1;
                }
            }
        }
        
        return -1;
    }
}