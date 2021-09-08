# DP
class Solution:
    def countPalindromicSubsequences(self, s: str) -> int:
        n = len(s)
        if n == 0: return 0
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        
        for size in range(2, n+1):
            for i in range(n - size + 1):
                j = i + size - 1
                if s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1] * 2
                    l = i+1
                    r = j-1
                    # find the first char from left in substring equals s[i]
                    while l <= r and s[l] != s[i]: l+=1
                    # find the first char from right in substring equals s[i]
                    while l <= r and s[r] != s[i]: r-=1
                    # no char in substring equals to s[i]
                    if l > r: dp[i][j] += 2
                    # found only 1 char in substring equals to s[i]
                    elif l == r : dp[i][j] += 1
                    # found 2 chars in substring equals to s[i]
                    else: dp[i][j] -= dp[l+1][r-1]
                else:
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
                dp[i][j] %= 1000000007
            
        return dp[0][n-1]
