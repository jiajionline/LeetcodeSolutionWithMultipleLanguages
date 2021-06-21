public class Solution {
    public bool CanJump(int[] nums) {
        if(nums == null || nums.Length == 0) return false;
        if(nums.Length == 1) return true;
        int furthestPos = 0;
        
        for(int i=0;i<nums.Length;i++)
        {
            if(furthestPos < i){
                return false;
            }else if(furthestPos >= nums.Length-1){
                return true;
            }else{
                furthestPos = Math.Max(furthestPos, nums[i] + i);
            }
        }
        
        return furthestPos >= nums.Length-1;
    }
}