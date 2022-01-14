class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int len=1; len <= n; len++)
            for(int l = 0; l<= n - len; l++)
            {
                int r = l + len - 1;
                ans += isPalindrome(s, l , r) ? 1 : 0;
            }
        
        return ans;
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) 
            if(s.charAt(l++) != s.charAt(r--)) 
                return false;
        return true;
    }
}