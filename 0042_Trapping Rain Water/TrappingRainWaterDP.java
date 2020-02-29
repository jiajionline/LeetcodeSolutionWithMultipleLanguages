class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++)
            left[i] = (i == 0) ? height[i] : Math.max(left[i - 1], height[i]);

        for (int i = n - 1; i >= 0; i--)
            right[i] = (i == n-1) ? height[i] : Math.max(right[i + 1], height[i]);

        for (int i = 0; i < n; i++)
            ans += Math.min(left[i], right[i]) - height[i];

        return ans;
    }
}