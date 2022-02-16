public class Solution {
    public int CombinationSum4(int[] nums, int target) {
        var memo = new int[target + 1];
        Array.Fill(memo, -1);
        memo[0] = 1;
        return CombinationSum4(nums, memo, target);
    }
    
    private int CombinationSum4(int[] nums, int[] memo, int target)
    {
        if(target < 0) return 0;
        if(memo[target] != -1) return memo[target];
        int ans = 0;
        foreach(var v in nums)
        {
            ans += CombinationSum4(nums, memo, target - v);
        }
        memo[target] = ans;
        return ans;
    }
}