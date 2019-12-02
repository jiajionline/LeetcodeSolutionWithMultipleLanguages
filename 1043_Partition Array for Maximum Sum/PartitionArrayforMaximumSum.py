class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        N = len(A)
        dp = [0] * (N+1)
        for i in range(N):
            curMax = 0
            for k in range(1, min(K,i+1)+1):
                curMax = max(curMax, A[i-k+1])
                dp[i] = max(dp[i], dp[i-k] + k * curMax)
        return dp[N-1]
