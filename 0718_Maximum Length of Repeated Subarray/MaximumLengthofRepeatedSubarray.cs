public class Solution {
    public int FindLength(int[] nums1, int[] nums2) {
        var m = nums1.Length;
        var n = nums2.Length;
        var ans = 0;
        var dp = new int[m+1,n+1];
        
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i,j] = dp[i-1,j-1] + 1;
                    ans = Math.Max(ans, dp[i,j]);
                }
            }
            
        return ans;
    }
}