class Solution {
    public boolean isMatch(String s, String p) {
        
        int sp = 0;
        int pp = 0;
        int starPos = -1;
        int match = 0;

        while(sp < s.length()){
            if(pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++;
                pp++;
            }else if(pp < p.length() && p.charAt(pp) == '*'){
                starPos = pp;
                match = sp;
                pp++;
            }else if(starPos != -1){
                pp = starPos + 1;
                match++;
                sp = match;
            }else{
                return false;
            }
        }

        while(pp < p.length() && p.charAt(pp) == '*') pp++;

        return pp == p.length();

    }
}