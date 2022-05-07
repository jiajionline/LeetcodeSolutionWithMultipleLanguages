class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    
    private boolean search(int[] nums, int l , int r, int target) {
        if(l > r)  return false;
        if(l == r) return nums[l] == target;
        int mid = (r-l)/2 + l;
        if(nums[l] < nums[mid] && nums[mid] < nums[r]) 
            return (target <= nums[mid]) ? search(nums, l, mid, target) : search(nums, mid+1, r, target);
        else
            return search(nums, l , mid, target) || search(nums, mid+1, r, target);
        }
}