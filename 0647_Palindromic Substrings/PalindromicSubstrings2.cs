public class Solution {
  
    public int CountSubstrings(string s) {
        var n = s.Length;
        var ans = 0;
        var memo = new bool[n,n];
        
        for(int len = 1;len <= n;len++)
        {
            for(int l = 0; l+len-1 < n;l++)
            {
                var r = l + len-1;
                if(IsPalindromic(s, l , r, memo))
                {
                    memo[l,r] = true;
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    private bool IsPalindromic(string s, int l , int r, bool[,] memo)
    {
        if(s[l] == s[r] && (r - l <=2 || memo[l+1,r-1])) return true;
        return false;
    }
}