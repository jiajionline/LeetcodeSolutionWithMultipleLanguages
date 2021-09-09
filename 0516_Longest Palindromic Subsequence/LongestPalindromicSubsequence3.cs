public class Solution {
    private int[,] _mem;
    public int LongestPalindromeSubseq(string s) {
        if(string.IsNullOrEmpty(s)) return 0;
        var len = s.Length;
        _mem = new int[len,len];
        
        return LPS(s, 0, len-1);
    }
    
    private int LPS(string s, int l , int r)
    {
        if(l > r) return 0;
        if(l == r) return 1;
        if(_mem[l,r] > 0) return _mem[l,r];
        
        if(s[l] == s[r])
        {
            _mem[l,r] = LPS(s, l+1, r-1) + 2;    
        }else
        {
            _mem[l,r] = Math.Max(LPS(s, l+1,r), LPS(s,l, r-1));
        }
        
        return _mem[l,r];
    }
}