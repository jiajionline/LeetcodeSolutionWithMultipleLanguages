class Solution {
    //[l,r) & upperBound
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        
        if(l-1 >= 0 && nums[l-1] == target) return l-1;
        return l;
    }
}