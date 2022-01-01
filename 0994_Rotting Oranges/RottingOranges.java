class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int fresh = 0;
        int[] dirs = new int[]{0,-1,0,1,0};
        Queue<int[]> queue = new ArrayDeque<int[]>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return ans;
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            while(size-- > 0) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                for(int i=0;i<4;i++) {
                    int x1 = x + dirs[i];
                    int y1 = y + dirs[i+1];
                    
                    if(x1 < 0 || y1 < 0 || x1 == m || y1 == n || grid[x1][y1] != 1) continue;
                    grid[x1][y1] = 2;
                    fresh--;
                    queue.add(new int[]{x1,y1});
                }
            }
            ans++;
            if(fresh == 0) return ans;
        }
        
        return fresh > 0 ? -1 : ans;
    }
}