public class Solution {
    public int MinSubArrayLen(int target, int[] nums) {
        var sum = 0;
        var l = 0;
        var ans = nums.Length + 1;
        for(int r = 0;r<nums.Length;r++)
        {
            sum += nums[r];
            
            while(sum >= target)
            {
                ans = Math.Min(r - l + 1, ans);
                sum -= nums[l++];
            }
        }
        
        return ans == nums.Length + 1 ? 0 : ans;
    }
}