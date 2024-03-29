class Solution {
    public boolean isNumber(String s) {
        if(s.isBlank()) return false;
        s = s.trim();
        s = s.toLowerCase();
        
        boolean hasE = false, hasDigit = false, hasDot = false;
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                hasDigit = true;
            }else if(c == '+' || c == '-') {
                if(i > 0 && s.charAt(i-1) != 'e') return false;
            }else if(c == 'e') {
                if(hasE || !hasDigit) return false;
                hasE = true;
                hasDigit = false;
            }else if(c == '.') {
                if(hasDot || hasE) return false;
                hasDot = true;
            }else {
                return false;
            }
        }
        
        return hasDigit;
    }
}