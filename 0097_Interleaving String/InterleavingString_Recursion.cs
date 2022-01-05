public class Solution {
    public bool IsInterleave(string s1, string s2, string s3) {
        var m = s1.Length;
        var n = s2.Length;
        // 0 is not initialized, 1 is false, 2 is true
        int[,] memo = new int[m+1, n+1];
        return IsInterleave(s1, m, s2, n, s3, s3.Length, memo);
    }
    
    private bool IsInterleave(string s1, int l1, string s2, int l2, string s3, int l3, int[,] memo)
    {
        if(l1 + l2 != l3) return false;
        //base case
        if(l1 == 0 && l2 == 0) return true;
        if(memo[l1, l2] > 0) return memo[l1, l2] == 2;
        
        if((l1 > 0 && s1[l1-1] == s3[l3-1] && IsInterleave(s1, l1-1, s2, l2, s3, l3-1, memo)) 
           ||
           (l2 > 0 && s2[l2-1] == s3[l3-1] && IsInterleave(s1, l1, s2, l2-1, s3, l3-1, memo)))
        {
            memo[l1, l2] = 2;
        }
        else
        {
            memo[l1, l2] = 1;
        }
        
        return memo[l1, l2] == 2;
           
    }
}


