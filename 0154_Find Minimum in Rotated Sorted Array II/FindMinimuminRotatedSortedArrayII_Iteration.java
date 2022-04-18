class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
    
    private int findMin(int[] nums, int l , int r) {
        if(l+1 >= r) return Math.min(nums[l], nums[r]);
        if(nums[l] < nums[r]) return nums[l];
        int mid = (r-l)/2 + l;
        return Math.min(findMin(nums, l, mid), findMin(nums, mid+1, r));
    }
}