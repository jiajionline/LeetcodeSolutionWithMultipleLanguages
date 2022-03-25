public class Solution {
    public int calculateArea(int[] heights, int l, int r) {
        if (l > r)
            return 0;
        int minindex = l;
        for (int i = l; i <= r; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (r - l + 1),
                        Math.max(calculateArea(heights, l, minindex - 1),
                                calculateArea(heights, minindex + 1, r))
                );
    }

    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}