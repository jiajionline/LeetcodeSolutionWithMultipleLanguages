class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans =0, lMax = height[0], rMax = height[n-1], l = 0, r = n-1;
        while(l <= r) {
            if(lMax <= rMax) {
                int h = Math.max(0, Math.min(lMax, rMax) - height[l]);
                ans += h;
                lMax = Math.max(lMax, height[l++]);
            }else{
                int h = Math.max(0, Math.min(lMax, rMax) - height[r]);
                ans += h;
                rMax = Math.max(rMax, height[r--]);
            }
        }
        
        return ans;
    }
}