class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int ans = nums[0];
        int lastMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (lastMax < 0) {
                lastMax = nums[i];
            } else {
                lastMax += nums[i];
            }
            ans = Math.max(ans, lastMax);
        }

        return ans;
    }
}