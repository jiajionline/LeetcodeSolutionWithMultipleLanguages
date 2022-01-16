public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        var n = nums.Length;
        var ans = new int[n];
        Array.Fill(ans, 1);
        
        int l = 1, r = 1;
        
        for(int i=0;i<n;i++)
        {
            ans[i] *= l;
            ans[n - i - 1] *= r;
            l *= nums[i];
            r *= nums[n - i - 1];
        }
        
        return ans;
    }
}