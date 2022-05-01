class Solution {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1,  p2 = t.length() - 1;
        int skipS = 0, skipT = 0;
        
        while(p1 >= 0 || p2 >= 0) {
            while(p1>=0) {
                if(s.charAt(p1) == '#') { skipS++; p1--; }
                else if(skipS > 0) { skipS--; p1--; }
                else break;
            }
            
            while(p2>=0) {
                if(t.charAt(p2) == '#') { skipT++; p2--; }
                else if(skipT > 0) { skipT--; p2--; }
                else break;
            }
            
            if(p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2)) return false;
            //p1 & p1 need to >= 0 or both < 0 at the same time
            if(p1>=0 != p2>=0) return false;
            
            p1--;
            p2--;
        }
        
        return true;
    }
}