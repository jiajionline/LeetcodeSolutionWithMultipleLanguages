public class Solution {
    public int LongestSubarray(int[] nums) {
        if(nums == null || nums.Length <= 1) return 0;
        var dpL = new int[nums.Length];
        var dpR = new int[nums.Length];
        
        for(int i=0;i<nums.Length;i++){
            dpL[i] = i > 0 ? (nums[i] == 0 ? 0 : dpL[i-1] +1) : nums[i];
        }
        
        for(int i=nums.Length-1;i>=0;i--){
            dpR[i] = i < nums.Length-1 ? (nums[i] == 0 ? 0 : dpR[i+1] + 1) : nums[i];
        }
        
        var ans = 0;
        
        for(int i=0;i<nums.Length;i++){
            ans = Math.Max(ans, (i>0? dpL[i-1]:0) + (i<nums.Length-1 ? dpR[i+1] : 0));
        }
        
        return ans;
    }
}