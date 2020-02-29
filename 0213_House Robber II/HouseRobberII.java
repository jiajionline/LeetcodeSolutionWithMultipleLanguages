class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        
        return Math.max(rob(nums, nums[0], nums[0], 2,n-1), rob(nums, 0, nums[1],2,n));
       
    }

    private int rob(int[] nums, int previous, int current, int start, int end){
        for(int i=start;i<end;i++){
            int next = Math.max(current, previous + nums[i]);
            previous = current;
            current = next;
        }       

        return current;
    }
}