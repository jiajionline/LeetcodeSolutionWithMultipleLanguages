class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int ans = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j,dirs);
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(char[][] grid, int x, int y,int[][] dirs) {
        if(x < 0 || y < 0 || x == grid.length || y == grid[x].length || grid[x][y] != '1') return;
        grid[x][y] = '0';
        for(int i=0;i<dirs.length;i++) {
            int dx = dirs[i][0] + x, dy = dirs[i][1] + y;
            dfs(grid, dx, dy, dirs);
        }
    }
}