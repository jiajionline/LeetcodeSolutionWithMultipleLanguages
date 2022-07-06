class Solution {
    public int longestValidParentheses(String s) {
        int cntL = 0, cntR = 0, ans = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(')
                cntL++;
            else
                cntR++;
            
            if(cntL == cntR) {
                ans = Math.max(ans, cntL*2);
            }else if(cntR > cntL) {
                cntL = 0;
                cntR = 0;
            }
        }
        
        cntL = 0;
        cntR = 0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == '(')
                cntL++;
            else
                cntR++;
            
            if(cntL == cntR) {
                ans = Math.max(ans, cntL*2);
            }else if(cntL > cntR) {
                cntL = 0;
                cntR = 0;
            }
        }
        
        return ans;
    }
}