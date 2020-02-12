public class Solution {
    public int MaxAreaOfIsland(int[][] grid) {
        if(grid == null) return 0;
        int max = 0;
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[i].Length;j++){
                max = Math.Max(max, DFS(grid,i,j,grid.Length,grid[i].Length));
            }
        }
        return max;
    }

    private int DFS(int[][] grid, int i, int j, int rowLen, int colLen)
    {
        if(i<0 || j<0 || i>=rowLen || j>=colLen || grid[i][j]==0) return 0;
        grid[i][j] = 0;
        return  DFS(grid,i-1,j,rowLen,colLen) +
                DFS(grid,i,j-1,rowLen,colLen) +
                DFS(grid,i+1,j,rowLen,colLen) + 
                DFS(grid,i,j+1,rowLen,colLen) +
                1;
    }
}