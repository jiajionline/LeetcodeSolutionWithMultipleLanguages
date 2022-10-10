//Recursion + Memoization to avoid duplicate computation
class Solution {
    public int numDecodings(String s) {
        return numDecodings(0,s,new HashMap<>());
    }
    
    private int numDecodings(int index, String str, Map<Integer,Integer> memo) {
        if(memo.containsKey(index)) return memo.get(index);
        
        // If you reach the end of the string, return 1 for success.
        if(index == str.length()) return 1;
        
        // '0' can't be decoded
        if(str.charAt(index) == '0') return 0;
        
        if(index == str.length() - 1) return 1;
        
        int ans = numDecodings(index+1,str,memo);
        if(Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += numDecodings(index+2, str, memo);
        }
        
        memo.put(index, ans);
        return ans;
    }
}