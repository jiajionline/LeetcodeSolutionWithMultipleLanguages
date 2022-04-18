class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(nums[mid] < nums[r]) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        
        return nums[l];
    }
}