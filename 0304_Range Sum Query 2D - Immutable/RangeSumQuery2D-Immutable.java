class NumMatrix {

    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        var m = matrix.length;
        var n = matrix[0].length;
        dp = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        var minI = Math.min(row1, row2);
        var maxI = Math.max(row1, row2);
        var minJ = Math.min(col1, col2);
        var maxJ = Math.max(col1, col2);
        
        return dp[maxI+1][maxJ+1] - dp[maxI+1][minJ] - dp[minI][maxJ+1] + dp[minI][minJ];
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.SumRegion(row1,col1,row2,col2);
 */