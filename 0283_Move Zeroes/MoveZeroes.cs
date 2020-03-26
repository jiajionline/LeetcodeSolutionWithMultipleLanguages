class Solution {
    public void MoveZeroes (int[] nums) {
        if (nums == null || nums.Length <= 1) return;
        int copyIndex = 0;
        int currentIndex = 0;

        while (currentIndex < nums.Length) {
            if (nums[currentIndex] != 0) {
                nums[copyIndex++] = nums[currentIndex];
            }

            currentIndex++;
        }

        while (copyIndex < nums.Length) {
            nums[copyIndex++] = 0;
        }
    }
}