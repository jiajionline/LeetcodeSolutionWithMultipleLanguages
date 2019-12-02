public class Solution {
    public int MaxSumAfterPartitioning(int[] A, int K) {
        if(A==null || K<=0) return 0;
        var N = A.Length;
        var dp = new int[N];
        for(int i=0;i<N;i++)
        {
            int curMax = 0;
            for(int k=1;k<=K && i-k+1>=0;k++){
                curMax = Math.Max(curMax, A[i-k+1]);
                dp[i] = Math.Max(dp[i], (i>=k ? dp[i-k]:0) + curMax * k);
            }
        }
        return dp[N-1];
    }
}