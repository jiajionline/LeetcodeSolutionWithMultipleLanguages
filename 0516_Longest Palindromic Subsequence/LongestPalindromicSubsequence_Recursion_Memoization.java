class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.isEmpty()) return 0;
        int n = s.length();
        int[][] memo = new int[n][n];
        return longestPalindromeSubseq(s, 0, n-1, memo);
    }
    
    private int longestPalindromeSubseq(String s, int l , int r, int[][] memo) {
        if(l > r) return 0;
        if(l == r) return 1;
        if(memo[l][r] > 0) return memo[l][r];
        
        int ans = 0;
        if(s.charAt(l) ==s.charAt(r)) {
            ans = longestPalindromeSubseq(s, l+1, r-1, memo) + 2;
        }else{
            ans = Math.max(longestPalindromeSubseq(s, l+1, r, memo), longestPalindromeSubseq(s, l, r-1, memo));
        }
        
        memo[l][r] = ans;
        return ans;
    }
}