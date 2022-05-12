class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        for(int l = 0; l < nums.length - 2; l++) {
            int diff = nums[l + 1] - nums[l];
            for(int r = l + 2; r < nums.length; r++) {
                if(nums[r] - nums[r-1] == diff) ans++;
                else break;
            }
        }
        return ans;
    }
}
