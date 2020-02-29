class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        
        int previous = nums[0];
        int current = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            int next = Math.max(current, previous + nums[i]);
            previous = current;
            current = next;
        }
        
        return current;
    }
}