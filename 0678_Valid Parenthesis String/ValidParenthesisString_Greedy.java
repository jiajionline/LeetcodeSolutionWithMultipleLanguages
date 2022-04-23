class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for(char c : s.toCharArray()) {
            lo += (c == '(') ? 1 : -1;
            hi += (c != ')') ? 1 : -1;
            if(hi < 0) return false;
            lo = Math.max(0, lo);
        }
        
        return lo == 0;
    }
}