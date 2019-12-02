public class Solution {
    public int FirstMissingPositive (int[] nums) {
        if (nums == null || nums.Length == 0) return 1;
        for (int i = 0; i < nums.Length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.Length && nums[nums[i] - 1] != nums[i]) {
                var tmp = nums[i];
                var tmp2 = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmp;
                nums[i] = tmp2;
            }
        }

        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums.Length + 1;
    }
}