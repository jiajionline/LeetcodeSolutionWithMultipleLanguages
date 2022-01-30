class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for(int i=0;i<heights.length;i++)
            ans = Math.max(area(heights, i), ans);
        
        return ans;
    }
    
    private int area(int[] heights, int i) {
        int l = i;
        int r = i;
        
        while(l >= 0 && heights[l] >= heights[i])
            l--;
        
        while(r < heights.length && heights[r] >= heights[i])
            r++;
        
        return (r - l - 1) * heights[i]; 
    }
}