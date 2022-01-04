public class Solution
{
    public bool PredictTheWinner(int[] nums)
    {
        var n = nums.Length;
        var dp = new int[n][];

        for(int i=0;i<dp.Length;i++)
        {
            dp[i] = new int[n];
            Array.Fill(dp[i], int.MinValue);
        }

        for (var i = 0; i < n; i++)
            dp[i][i] = nums[i];

        for (var len = 2; len <= n; len++)
        {
            for (var i = 0; i <= n - len; i++)
            {
                var j = i + len - 1;
                dp[i][j] = Math.Max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}