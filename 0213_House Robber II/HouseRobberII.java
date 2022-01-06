class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
        
    }
    
    private int rob(int[] nums, int from, int to) {
        int prev2 = nums[from];
        int prev1 = Math.max(prev2, nums[from+1]);
        
        for(int i=from+2;i<=to;i++) {
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}