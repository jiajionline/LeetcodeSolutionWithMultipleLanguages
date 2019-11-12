public class Solution {
    public int MaxSubArray (int[] nums) {
        if (nums == null || nums.Length == 0) return 0;
        if (nums.Length == 1) return nums[0];
        int ans = nums[0];
        int lastMax = nums[0];

        for (int i = 1; i < nums.Length; i++) {
            if (lastMax < 0) {
                lastMax = nums[i];
            } else {
                lastMax += nums[i];
            }

            ans = Math.Max (lastMax, ans);
        }

        return ans;
    }
}