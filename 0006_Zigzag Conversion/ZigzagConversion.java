class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) {
            sbs[i] = new StringBuilder();
        }
        
        int index = 0;
        while(index < s.length()) {
            for(int i=0;i<numRows && index < s.length(); i++) {
                sbs[i].append(s.charAt(index++));
            }
            
            for(int i= numRows-2;i > 0 && index < s.length() ;i--) {
                sbs[i].append(s.charAt(index++));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            ans.append(sbs[i]);
        }
        
        return ans.toString();
    }
}