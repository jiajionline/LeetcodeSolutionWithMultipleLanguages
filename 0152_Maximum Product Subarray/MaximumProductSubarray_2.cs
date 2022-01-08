public class Solution {
    public int MaxProduct(int[] nums) {
        var dpMax = new int[nums.Length];
        var dpMin = new int[nums.Length];
        
        dpMax[0] = dpMin[0] = nums[0];
        
        for(int i=1;i<nums.Length;i++)
        {
            dpMax[i] = Math.Max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]); 
            dpMax[i] = Math.Max(dpMax[i], nums[i]);
            
            dpMin[i] = Math.Min(dpMin[i-1] * nums[i], dpMax[i-1] * nums[i]);
            dpMin[i] = Math.Min(dpMin[i], nums[i]);
        }
        
        return dpMax.Max();
    }
}