public class Solution {
    public int Trap(int[] height) {
        var ans = 0;
        var dpLeft = new int[height.Length];
        var dpRight = new int[height.Length];
        
        for(int i=0;i<height.Length;i++)
        {
            dpLeft[i] = i==0 ? height[i] : Math.Max(dpLeft[i-1], height[i]);
        }
        
        for(int i=height.Length-1;i>=0;i--)
        {
            dpRight[i] = i == height.Length - 1 ? height[i] : Math.Max(dpRight[i+1], height[i]);
        }
        
        for(int i=0;i<height.Length;i++)
        {
            ans += Math.Min(dpLeft[i], dpRight[i]) - height[i];
        }
        
        return ans;
    }
}