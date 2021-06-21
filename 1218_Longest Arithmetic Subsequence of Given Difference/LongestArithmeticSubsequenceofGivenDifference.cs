public class Solution {
    public int LongestSubsequence(int[] arr, int difference) {
        var dp = new Dictionary<int,int>();
        var ans = 0;
        foreach(var v in arr){
            dp[v] = 1;
            
            if(dp.ContainsKey(v-difference)){
                dp[v] = dp[v-difference] + 1;
            }
            
            ans = Math.Max(ans, dp[v]);
        }
        
        return ans;
    }
}