class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        int l = 0, r = n - 1;
        int lMax = height[0], rMax = height[n-1];
        
        while(l < r) {
            if(lMax < rMax) {
                ans += lMax - height[l];
                lMax = Math.max(lMax, height[++l]);
            }else{
                ans += rMax - height[r];
                rMax = Math.max(rMax, height[--r]);
            }
        }
        
        return ans;
    }
}