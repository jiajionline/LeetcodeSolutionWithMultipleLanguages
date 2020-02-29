class Solution {
    public int trap(int[] height) {
        int ans = 0;
        for(int i=1;i<height.length-1;i++){
            int left = height[i];
            for(int j=0;j<i;j++){
                left = Math.max(left,height[j]);
            }
            int right = height[i];
            for(int j=i+1;j<height.length;j++){
                right = Math.max(right, height[j]);
            }

            ans += Math.min(left,right) - height[i];
        }
        
        return ans;
    }
}