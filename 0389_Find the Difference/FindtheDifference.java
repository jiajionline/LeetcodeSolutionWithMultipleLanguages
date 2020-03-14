class Solution {
    public char findTheDifference(String s, String t) {
        
        int ans = 0;
        for(char c1 : s.toCharArray()){
           ans ^= (int)c1;
        }
        
         for(char c2 : t.toCharArray()){
                ans ^= (int)c2;
            }
        
        return (char)ans;
    }
}