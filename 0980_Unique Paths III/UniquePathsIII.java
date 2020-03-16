class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int emptySquareCount = 1;
        int startX = -1;
        int startY = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }else if(grid[i][j] == 0){
                    emptySquareCount++;
                }
            }
        }

        return DFS(grid,startX,startY,m,n, emptySquareCount);
    }

    private int DFS(int[][] grid, int i, int j, int m,int n,int leftStep){
        if(i<0 || j < 0 || i>=m || j>=n || grid[i][j] == -1) return 0;
        if(grid[i][j] == 2){
            if(leftStep == 0) return 1;
            return 0;
        }

        grid[i][j] = -1;
        int ans =   DFS(grid,i-1,j,m,n,leftStep-1) +
                    DFS(grid,i,j-1,m,n,leftStep-1) +
                    DFS(grid,i+1,j,m,n,leftStep-1) +
                    DFS(grid,i,j+1,m,n,leftStep-1);
        grid[i][j] = 0;
        return ans;
    }
}