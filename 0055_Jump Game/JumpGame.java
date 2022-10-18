class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int furthest = 0;
        
        for(int i=0;i<n;i++) {
            if(i > furthest) return false;
            furthest = Math.max(furthest, nums[i] + i);
            if(furthest >= n-1) return true;
        }
        
        return furthest >= n-1;
    }
}