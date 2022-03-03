public class Solution {
    public int MinInsertions(string s) {
        var n = s.Length;
        var mem = new int[n][];
        for(int i=0;i<n;i++) {
            mem[i] = new int[n];
            Array.Fill(mem[i], -1);
        }
        
        return MinInsertions(s, 0, n-1, mem);
    }
    
    private int MinInsertions(string s, int l , int r, int[][] mem)
    {
        if(l >= r) return 0;
        if(mem[l][r] > -1) return mem[l][r];
        int v = 0;
        if(s[l] == s[r]){
            v = MinInsertions(s, l+1, r-1, mem);
        }
        else {
            v = Math.Min(MinInsertions(s, l+1, r, mem), MinInsertions(s, l, r-1, mem)) + 1;
        }
        mem[l][r] = v;
        return v;
    }
}