class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int i = 0;
        
        while(i <= r) {
            if(nums[i] == 0) {
                int tmp = nums[l];
                nums[l] = nums[i];
                nums[i] = tmp;
                l++;
                i++;
            }else if(nums[i] == 2) {
                int tmp = nums[r];
                nums[r] = nums[i];
                nums[i] = tmp;
                r--;
            }else
                i++;
        }
    }
}