public class Solution {
    public int LengthOfLIS(int[] nums) {
        if (nums == null || nums.Length == 0) return 0;
        if (nums.Length == 1) return 1;
        var ret = Enumerable.Repeat(1, nums.Length).ToArray();

        for (int i = 0; i < nums.Length; i++){
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ret[i] = Math.Max(ret[i], ret[j] + 1);
                }
            }
        }

        return ret.Max();
    }
}