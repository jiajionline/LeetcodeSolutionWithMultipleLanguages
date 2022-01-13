public class Solution {
    public int Trap(int[] height) {
        var n = height.Length;
        var leftDP = new int[n];
        var lMax = 0;
        for(int i=0;i<n;i++)
        {
            lMax = Math.Max(lMax, height[i]);
            leftDP[i] = lMax - height[i];
        }
        
        var rMax = 0;
        var rightDP = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            rMax = Math.Max(rMax, height[i]);
            rightDP[i] = rMax - height[i];
        }
        
        var ans = 0;
        
        for(int i=0;i<n;i++)
            ans += Math.Min(leftDP[i], rightDP[i]);
        
        return ans;
    }
}