class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        
        for(int i=0;i<n;i++) {
            ans += subCount(s,i,i);
            ans += subCount(s,i,i+1);
        }
                    
        return ans;
    }
    
    private int subCount(String s, int l, int r) {
        int count = 0;
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}