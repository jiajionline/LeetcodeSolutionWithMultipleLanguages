class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=m-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == n-1) {
                    matrix[i][j] += Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                }else{
                    matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }
        
        int ans = matrix[0][0];
        
        for(int i=1;i<n;i++)
            ans = Math.min(ans, matrix[0][i]);
        
        return ans;
    }
}