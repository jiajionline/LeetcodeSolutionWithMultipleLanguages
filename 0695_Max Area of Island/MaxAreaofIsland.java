class Solution {
    private int max;
    private int current;
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null) return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                current = 0;
                if(grid[i][j]==1){
                    check(grid,i,j,grid.length,grid[i].length);
                }
                max = Math.max(max, current);
            }
        }
        
        
        return max;    
    }
    
    private void check(int[][] grid, int i, int j,int rowLen, int colLen){
        if(i<0 || j<0 || i>=rowLen || j>=colLen || grid[i][j]==0) return;
        current++;
        grid[i][j] = 0;
        check(grid,i-1,j,rowLen,colLen);
        check(grid,i,j-1,rowLen,colLen);
        check(grid,i+1,j,rowLen,colLen);
        check(grid,i,j+1,rowLen,colLen);
    }
}