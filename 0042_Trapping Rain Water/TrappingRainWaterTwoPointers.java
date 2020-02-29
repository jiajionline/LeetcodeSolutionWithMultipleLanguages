class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int ans = 0;
        int n = height.length;
        int l = 0;
        int r = n-1;
        int maxHeight_l = height[l];
        int maxHeight_r = height[r];
        
        while(l<r){
            if(maxHeight_l < maxHeight_r){
                ans += maxHeight_l - height[l];
                maxHeight_l = Math.max(maxHeight_l, height[++l]);
            }else{
                ans += maxHeight_r - height[r];
                maxHeight_r = Math.max(maxHeight_r, height[--r]);
            }
        }

        return ans;
    }
}