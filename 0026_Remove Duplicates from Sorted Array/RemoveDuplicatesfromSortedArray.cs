public class Solution {
    public int RemoveDuplicates (int[] nums) {
        if (nums == null || nums.Length == 0) return 0;
        if (nums.Length == 1) return 1;
        int currentIndex = 0, nextIndex = 0;

        while (nextIndex < nums.Length) {
            if (nums[currentIndex] != nums[nextIndex]) {
                currentIndex++;
                nums[currentIndex] = nums[nextIndex];
            }
            nextIndex++;
        }

        return currentIndex + 1;
    }
}