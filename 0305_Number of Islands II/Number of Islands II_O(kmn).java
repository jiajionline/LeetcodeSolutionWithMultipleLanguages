class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>(positions.length);
        if(positions.length == 0 || m <= 0 || n <= 0) return ans;
        
        int[] pos = new int[]{0,1,0,-1,0};
        int[][] grid = new int[m][n];
        Set<Integer> set = new HashSet();
        int landIndex = 0;
        
        for(int i=0;i<positions.length;i++) {
            landIndex++;
            int x = positions[i][0];
            int y = positions[i][1];
            set.remove(grid[x][y]);
            grid[x][y] = landIndex;
            set.add(landIndex);
            
            for(int j=0;j<4;j++) {
                int dx = x + pos[j];
                int dy = y + pos[j+1];
                DFS(grid, dx, dy, m, n, landIndex, set, pos);
            }
            
            ans.add(set.size());
        }
        
        return ans;
    }
    
    private void DFS(int[][] grid, int x, int y, int m, int n, int landIndex, Set<Integer> set, int[] pos) {
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == landIndex) return;
        if(set.contains(grid[x][y])) {
            set.remove(grid[x][y]);
        }
        
        grid[x][y] = landIndex;
        for(int i=0;i<4;i++) {
            int dx = x + pos[i];
            int dy = y + pos[i+1];
            DFS(grid, dx, dy, m, n, landIndex, set, pos);
        }     
    }
}