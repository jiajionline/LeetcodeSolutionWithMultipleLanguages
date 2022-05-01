class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }
    
    private String backspace(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '#') {
                if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}