public class Solution {
    public bool IsInterleave(string s1, string s2, string s3) {
        var l1 = s1.Length;
        var l2 = s2.Length;
        var l3 = s3.Length;
        if(l1 + l2 != l3) return false;
        // dp[i,j]: whehter s3[0:i+j] is a interleaving of s1[0:i] and s2[0:j]

        bool[,] dp = new bool[l1+1, l2+1];
        dp[0,0] = true;
        for(var i=0;i<=l1;i++)
        {
            for(var j=0;j<=l2;j++)
            {
                if(i>0 && s1[i-1] == s3[i+j-1])
                    dp[i,j] = dp[i-1,j];
                
                if(!dp[i,j])
                {
                    if(j>0 && s2[j-1] == s3[i+j-1])
                        dp[i,j] = dp[i,j-1];
                }
            }
        }
        
        return dp[l1,l2];
    }
}


