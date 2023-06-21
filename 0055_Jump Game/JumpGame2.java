class Solution {
    public boolean canJump(int[] nums) {
        int furthest = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(furthest < i) return false;
            furthest = Math.max(furthest, i + nums[i]);
        }
        
        return true;
    }
}