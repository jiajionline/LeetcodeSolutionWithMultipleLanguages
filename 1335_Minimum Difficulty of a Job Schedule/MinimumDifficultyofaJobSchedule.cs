public class Solution {
    public int MinDifficulty(int[] jobDifficulty, int d) {
        var n = jobDifficulty.Length;
        if(n < d) return -1;
        
        var dp = new int[n+1,d+1];
        for(int i=0;i<dp.GetLength(0);i++)
            for(int j=0;j<dp.GetLength(1);j++)
                dp[i,j] = int.MaxValue/2;
        
        dp[0,0] = 0;
        
        for(int i=1;i<=n;i++)
        {
            for(int k=1;k<=d;k++)
            {
                // max difficulty 
                int md = 0;
                for(int j=i-1;j>=k-1;j--)
                {
                    md = Math.Max(md, jobDifficulty[j]);
                    dp[i,k] = Math.Min(dp[i,k], dp[j,k-1] + md );
                }
                
            }
        }
        
        return dp[n,d];
    }
}