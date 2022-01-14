//Recursion (Brute Force)
class Solution {
    public int numDecodings(String s) {
        return ways(s);
    }
    
    private int ways(String s) {
        if(s.isEmpty()) return 1;
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        
        int ans = ways(s.substring(1));
        int twoDigits = Integer.parseInt(s.substring(0,2));
        if(twoDigits >= 10 && twoDigits <= 26) {
            ans += ways(s.substring(2));
        }
        
        return ans;
    }
}