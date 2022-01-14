class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int l = 0; l < n ; l++)
            for(int r = l; r < n; r++)
                ans += isPalindrome(s, l , r) ? 1 : 0;
        return ans;
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) 
            if(s.charAt(l++) != s.charAt(r--)) 
                return false;
        return true;
    }
}