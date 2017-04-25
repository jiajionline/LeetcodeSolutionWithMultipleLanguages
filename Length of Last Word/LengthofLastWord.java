
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int last = s.length() - 1;
        
        while(last >=0 && s.charAt(last) == ' '){
        	last--;
        }
        
        int first = last;
        
        while(first >= 0 && s.charAt(first) != ' '){
        	first--;
        }
        
        return last - first;
    }
}
