class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }
    
    private int findPeakElement(int[] nums, int l , int r) {
        if(l == r) return l;
        int mid = (r-l)/2 + l;
        if(nums[mid] > nums[mid+1])
            return findPeakElement(nums, l , mid);
        else
            return findPeakElement(nums, mid + 1, r);
    }
}