class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        if(m > n) return false;
        int[] cntOfS1 = new int[26];
        int[] cntOfS2 = new int[26];
        
        for(int i=0;i<m;i++){
            cntOfS1[s1.charAt(i) - 'a']++;
            cntOfS2[s2.charAt(i) - 'a']++;
        }
        
        if(isMatch(cntOfS1, cntOfS2)) return true;
            
        for(int i=m;i<n;i++) {
            cntOfS2[s2.charAt(i) - 'a']++;
            cntOfS2[s2.charAt(i-m) - 'a']--;
            if(isMatch(cntOfS1, cntOfS2)) return true;
        }
        
        return false;
    }
    
    private boolean isMatch(int[] cntOfS1, int[] cntOfS2) {
        if(cntOfS1.length != cntOfS2.length) return false;
        for(int i=0;i<cntOfS1.length;i++) {
            if(cntOfS1[i] != cntOfS2[i]) return false;
        }
        
        return true;
    }
}