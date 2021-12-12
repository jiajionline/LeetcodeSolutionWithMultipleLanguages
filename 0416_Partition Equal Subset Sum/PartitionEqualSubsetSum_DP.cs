public class Solution {
    public bool CanPartition(int[] nums) {
        var sum = nums.Sum();
        if(sum % 2 != 0) return false;
        
        var dp = new bool[sum+1];
        dp[0] = true;
        
        for(int i=0;i<nums.Length;i++)
            for(int j=sum;j>=0;j--)
            {
                if(dp[j]) dp[j+nums[i]] = true;
                if(dp[sum/2]) return true;
            }
       return false;
    }
}