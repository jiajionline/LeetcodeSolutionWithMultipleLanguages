public class Solution {
    public int MinFallingPathSum(int[][] matrix) {
        var m = matrix.Length;
        var n = matrix[0].Length;
        var dp = new int[m,n];
        
        for(int i=0;i<n;i++)
        {
            dp[0,i] = matrix[0][i];
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                var a = int.MaxValue;
                if(j-1 >=0) a = dp[i-1,j-1];
                var b = dp[i-1,j];
                var c = int.MaxValue;
                if(j+1 < n) c = dp[i-1,j+1];
                
                dp[i,j] = Math.Min(a, Math.Min(b,c)) + matrix[i][j];    
            }
        }
        
        var ans = int.MaxValue;
        for(int i=0;i<n;i++)
        {
            ans = Math.Min(ans, dp[m-1,i]);
        }
        
        return ans;
    }
}