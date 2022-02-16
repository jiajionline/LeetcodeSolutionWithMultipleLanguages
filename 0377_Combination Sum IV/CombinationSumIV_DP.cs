public class Solution {
    public int CombinationSum4(int[] nums, int target) {
        var dp = new int[target + 1];
        dp[0] = 1;
        for(int i=1;i<=target;i++)
        {
            foreach(var v in nums)
            {
                if(i - v >= 0)
                    dp[i] += dp[i-v];
            }
        }
        return dp[target];
    }
}