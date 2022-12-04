class Solution {
    public int minAddToMakeValid(String s) {
        int l = 0, r = 0;
        for(char c : s.toCharArray()) {
            if(c == '('){
                l++;
            }
            
            if(c == ')') {
                if(l > 0) l--;
                else r++;
            }
        }
        
        return l + r;
    }
}