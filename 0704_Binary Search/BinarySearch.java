class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length;
        while(l < r){
            int m = l + ( r - l)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] > target){
                r = m;
            }else{
                l = m+1;
            }
        }

        return -1;
    }
}