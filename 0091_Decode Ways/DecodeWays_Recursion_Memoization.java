//Recursion + Memoization to avoid duplicate computation
class Solution {
    public int numDecodings(String s) {
        return ways(s, new HashMap<String, Integer>());
    }
    
    private int ways(String s, HashMap<String, Integer> memo) {
        if(s.isEmpty()) return 1;
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        if(memo.containsKey(s)) return memo.get(s);
        
        int ans = ways(s.substring(1), memo);
        int twoDigits = Integer.parseInt(s.substring(0,2));
        if(twoDigits >= 10 && twoDigits <= 26) {
            ans += ways(s.substring(2), memo);
        }
        
        memo.put(s,ans);
        
        return ans;
    }
}