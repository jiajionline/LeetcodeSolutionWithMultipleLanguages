class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        return validWordAbbreviation(word, 0, abbr, 0);
    }
    
    private boolean validWordAbbreviation(String word, int p1, String abbr, int p2) {
        if(p1 == word.length() && p2 == abbr.length()) return true;
        if(p1 >= word.length() || p2 >= abbr.length()) return false;
        
        if(word.charAt(p1) == abbr.charAt(p2)) {
            return validWordAbbreviation(word, p1+1, abbr, p2 + 1);
        }else if(abbr.charAt(p2) <= '0' || abbr.charAt(p2) > '9') {
            return false;
        }else{
            int start = p2;
            while(p2 < abbr.length() && Character.isDigit(abbr.charAt(p2))) p2++;
            
            int num = Integer.valueOf(abbr.substring(start, p2));
            p1 += num;
            return validWordAbbreviation(word, p1, abbr, p2);
        }
    }
}