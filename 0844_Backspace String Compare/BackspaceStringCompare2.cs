public class Solution {
    public bool BackspaceCompare(string s, string t) 
    {
        if(string.IsNullOrWhiteSpace(s) && string.IsNullOrWhiteSpace(t)) return true;
        if(string.IsNullOrWhiteSpace(s) || string.IsNullOrWhiteSpace(t)) return false;
        
        int p1 = s.Length - 1, p2 = t.Length - 1;
        int skipS = 0, skipT = 0;
        
        while(p1 >= 0 || p2 >= 0)
        {
            while( p1 >= 0)
            {
                if(s[p1] == '#')  { skipS++; p1--;}
                else if(skipS > 0){ skipS--; p1--;}
                else break;
            }
            
            while( p2 >= 0)
            {
                if(t[p2] == '#')  { skipT++; p2--;}
                else if(skipT > 0){ skipT--; p2--;}
                else break;
            }
            
            if(p1>=0 && p2>=0 && s[p1] != t[p2]) return false;
            if(p1>=0 != p2>=0) return false;
            p1--; p2--;
        }
        
        return true;
    }
}