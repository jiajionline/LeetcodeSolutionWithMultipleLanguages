public class Solution {
    public int Rob(int[] nums) {
        if(nums.Length == 1) return nums[0];
        var v1 = nums[0];
        var v2 = Math.Max(v1, nums[1]);
        
        for(int i=2;i<nums.Length;i++)
        {
            var v = Math.Max(v1 + nums[i], v2);
            v1 = v2;
            v2 = v;
        }
        
        return v2;
    }
}