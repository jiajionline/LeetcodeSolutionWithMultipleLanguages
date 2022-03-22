class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        
        while(l < r) {
            int m = (r-l)/2 + l;
            if(m <= 0 || m+1 >= n) return nums[m];
            var k = m % 2 == 0 ? m + 1 : m - 1;
            
            if(nums[m] == nums[k]) {
                l = m + 1;
            }else {
                r = m;
            }
        }
        
        return nums[l];
    }
}