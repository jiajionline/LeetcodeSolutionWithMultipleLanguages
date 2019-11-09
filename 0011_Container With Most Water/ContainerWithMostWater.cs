public class Solution {
    public int MaxArea (int[] height) {
        if (height == null || height.Length <= 1) return 0;
        int left = 0;
        int right = height.Length - 1;
        int max = 0;
        while (left < right) {
            max = Math.Max (max, Math.Min (height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}