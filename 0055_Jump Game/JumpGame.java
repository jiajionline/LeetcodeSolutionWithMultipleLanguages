class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        //no need to jump
        if(nums.length == 1) return true;
        
        int furthestPos = 0;
        for(int i=0;i<nums.length;i++){
            if(furthestPos < i){
                return false;
            }else if(furthestPos >= nums.length-1){
                return true;
            }else{
                furthestPos = Math.max(furthestPos, nums[i] + i);
            }
        }
        
        return furthestPos >= nums.length-1;
    }
}