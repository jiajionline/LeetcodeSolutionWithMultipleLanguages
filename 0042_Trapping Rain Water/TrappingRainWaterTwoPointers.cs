public class Solution {
    public int Trap(int[] height) {
        var ans = 0;
        var leftMax = height[0];
        var rightMax = height[height.Length-1];
        var left = 0;
        var right = height.Length -1;
        while(left < right)
        {
            if(leftMax < rightMax)
            {
                ans += leftMax - height[left];
                leftMax = Math.Max(leftMax, height[++left]);
            }else{
                ans += rightMax - height[right];
                rightMax = Math.Max(rightMax, height[--right]);
            }
        }
        
        return ans;
        
    }
}