class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, s1.length(), s2, s2.length(), s3, s3.length(), memo);
    }
    
    private boolean isInterleave(String s1, int p1, String s2, int p2, String s3, int p3, int[][] memo) {
        if(p1 + p2 != p3) return false;
        if(p1 == 0 && p2 == 0) return true;
        if(memo[p1][p2] > 0) return memo[p1][p2] == 2;
        if((p1 > 0 && s1.charAt(p1-1) == s3.charAt(p3-1) && isInterleave(s1, p1-1, s2, p2, s3, p3-1, memo)) || 
           (p2 > 0 && s2.charAt(p2-1) == s3.charAt(p3-1) && isInterleave(s1, p1, s2, p2-1, s3, p3-1, memo))){
            memo[p1][p2] = 2;
        }else{
            memo[p1][p2] = 1;
        }
        
        return memo[p1][p2] == 2;
    }
}