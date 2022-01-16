public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        var n = nums.Length;
        var l = new int[n];
        var r = new int[n];
        Array.Fill(l, 1);
        Array.Fill(r, 1);
        
        for(int i=1;i<n;i++)
            l[i] = l[i-1] * nums[i-1];
        
        for(int i=n-2;i>=0;i--)
            r[i] = r[i+1] * nums[i+1];
        
        var ans = new int[n];
        for(int i=0;i<n;i++)
            ans[i] = l[i] * r[i];
        
        return ans;
    }
}