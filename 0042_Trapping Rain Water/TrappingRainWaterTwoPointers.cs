public class Solution {
    public int Trap(int[] height) {
        var ans = 0;
        var l = 0;
        var r = height.Length - 1;
        var l_max = height[l];
        var r_max = height[r];
        
        while(l < r)
        {
            if(l_max <= r_max)
            {
                ans += l_max - height[l];
                l_max = Math.Max(l_max, height[++l]);
            }
            else
            {
                ans += r_max - height[r];
                r_max = Math.Max(r_max, height[--r]);
            }
        }
        
        return ans;
    }
}