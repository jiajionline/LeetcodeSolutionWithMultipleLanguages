public class Solution {
    public int MaxFrequency(int[] nums, int k) {
        Array.Sort(nums);
        
        var l = 0;
        var ans = 0;
        long sum = 0;
        for(var r=0;r < nums.Length;r++)
        {
            sum+=nums[r];
            while(l < r && (sum + k) < nums[r] * (r - l + 1))
                sum -= nums[l++];
            ans = Math.Max(ans, r - l + 1);
        }
        
        return ans;
    }
}