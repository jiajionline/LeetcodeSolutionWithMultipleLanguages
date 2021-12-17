public class Solution {
    public int MaximalSquare(char[][] matrix) {
        if(matrix == null || matrix.Length == 0 || matrix[0].Length == 0) return 0;
        var m = matrix.Length;
        var n = matrix[0].Length;
        
        var ans = 0;
        
        var dp = new int[m+1,n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i,j] = Math.Min(dp[i-1,j], Math.Min(dp[i,j-1], dp[i-1,j-1])) + 1;
                }
                
                ans = Math.Max(ans, dp[i,j]);
            }
        }
        
        return ans * ans;
    }
}