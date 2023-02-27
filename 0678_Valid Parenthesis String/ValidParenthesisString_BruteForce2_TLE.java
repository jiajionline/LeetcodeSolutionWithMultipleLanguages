class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }
    
    private boolean checkValidString(String s, int index, int l) {
        if(l < 0) return false;
        if(index == s.length()) {
            if(l > 0) return false;
            return true;
        }
        
        char c = s.charAt(index);
        if(c == '(') return checkValidString(s, index+1, l+1);
        else if(c == ')') 
            return checkValidString(s, index+1, l-1);
        else{
            return checkValidString(s, index+1, l) || checkValidString(s, index+1, l+1) ||  checkValidString(s, index+1, l-1);
        }
    }
}