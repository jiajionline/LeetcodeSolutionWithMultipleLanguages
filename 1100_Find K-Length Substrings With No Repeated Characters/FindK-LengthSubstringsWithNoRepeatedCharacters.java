class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        if(n < k) return 0;
        int[] count = new int[26];
        int ans = 0;
        
        for(int i=0;i<k;i++) count[s.charAt(i) - 'a']++;
        if(check(count)) ans++;
        
        for(int i=k;i<n;i++) {
            count[s.charAt(i-k)-'a']--;
            count[s.charAt(i)-'a']++;
            if(check(count)) ans++;
        }
        
        return ans;
        
    }
    
    private boolean check(int[] count) {
        for(int v : count) {
            if(v > 1) return false;
        }
        
        return true;
    }
}