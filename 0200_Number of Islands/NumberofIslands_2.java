class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int[] dirs = new int[]{1,0,-1,0,1};

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1')
                {
                    ans++;
                    DFS(grid, i, j, dirs);
                }
            }
        
        return ans;
    }
    
    private void DFS(char[][] grid, int x, int y, int[] dirs)
    {
        if(x < 0 || y < 0 || x == grid.length || y == grid[x].length || grid[x][y] != '1') return;
        grid[x][y] = '2';
        
        for(int i=0;i<4;i++){
            int dx = x + dirs[i];
            int dy = y + dirs[i+1];
            DFS(grid, dx, dy, dirs);
        }
    }
}