public class Solution {
    public int FindLongestChain(int[][] pairs) {
        Array.Sort(pairs, (a,b) => a[0].CompareTo(b[0]));
        
        var ans = 1;
        var dp = new int[pairs.Length];
        Array.Fill(dp,1);
        
        for(int i=1;i<pairs.Length;i++)
        {
            int j = i-1;
            while(j >=0)
            {
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = dp[j] + 1;
                    ans = Math.Max(ans, dp[i]);
                    break;
                }
                j--;
            }
        }
        
        return ans;
    }
}