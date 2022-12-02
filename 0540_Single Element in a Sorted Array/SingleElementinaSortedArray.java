class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while(l < r) {
            int m = (r-l)/2 + l;
            int k = m % 2 == 0 ? m + 1 : m - 1;
            
            if(nums[m] == nums[k]) {
                l = m + 1;
            }else {
                r = m;
            }
        }
        
        return nums[l];
    }
}