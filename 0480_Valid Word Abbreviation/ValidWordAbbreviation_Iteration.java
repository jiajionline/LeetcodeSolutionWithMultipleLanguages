class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int p1 = 0, p2 = 0;
        while(p1 < word.length() && p2 < abbr.length()) {
            if(word.charAt(p1) == abbr.charAt(p2)) {
                p1++;
                p2++;
                continue;
            }
            
            if(abbr.charAt(p2) <= '0' || abbr.charAt(p2) > '9') return false;
            
            int start = p2;
            while(p2 < abbr.length() && Character.isDigit(abbr.charAt(p2))) p2++;
            int num = Integer.valueOf(abbr.substring(start, p2));
            p1+= num;
        }
        
        return p1 == word.length() && p2 == abbr.length();
        
    }
}