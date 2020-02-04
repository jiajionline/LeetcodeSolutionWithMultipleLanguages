class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return Integer.MIN_VALUE;
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int l, int r){
        if(l+1 >= r) return Math.min(nums[l],nums[r]); 
        if(nums[l] < nums[r]) return nums[l];
        int m = l + (r - l)/2;
        return Math.min(findMin(nums, l, m), findMin(nums, m+1, r));
    }
}