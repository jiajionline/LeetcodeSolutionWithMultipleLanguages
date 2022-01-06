class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        if(m == 0) return mat;
        
        int n = mat[0].length;
        
        if(m*n != r * c) return mat;
        
        int row = 0;
        int col = 0;
        int[][] ans = new int[r][c];
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                ans[row][col++] = mat[i][j];
                
                if(col == c) {
                    row++;
                    col = 0;
                }
            }
        
        return ans;
    }
}