class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <=1) return s;
        String ans = s.substring(0, 1);
        int n = s.length();
        for(int i=0;i<n-1;i++){
            String tmp = expandAroundCenter(s, i, i);
            if(tmp.length() > ans.length()){
                ans = tmp;
            }

            tmp = expandAroundCenter(s, i, i+1);
            if(tmp.length() > ans.length()){
                ans = tmp;
            }
        }

        return ans;
    }

    private String expandAroundCenter(String s, int c1, int c2){
        int l = c1;
        int r = c2;
        int n = s.length();
        while(l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return s.substring(l+1, r);
    }
}