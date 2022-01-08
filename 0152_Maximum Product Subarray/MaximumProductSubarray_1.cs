public class Solution {
    public int MaxProduct(int[] nums) {
        var lastMax = nums[0];
        var lastMin = nums[0];
        var ans = nums[0];
        
        for(int i=1;i<nums.Length;i++)
        {
            var currMax = Math.Max(lastMax * nums[i], lastMin * nums[i]); 
            currMax = Math.Max(currMax, nums[i]);
            
            var currMin = Math.Min(lastMin * nums[i], lastMax * nums[i]);
            currMin = Math.Min(currMin, nums[i]);
            
            ans = Math.Max(ans, currMax);
            lastMax = currMax;
            lastMin = currMin;
        }
        
        return ans;
    }
}