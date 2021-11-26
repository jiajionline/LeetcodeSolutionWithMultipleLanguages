public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        return CanBreak(s,  new HashSet<string>(wordDict));
        
    }
    
    private bool CanBreak(string s,  HashSet<string> set)
    {
        if(set.Contains(s))
        {
            return true;
        }
        
        for(int i=1;i<s.Length;i++)
        {
            if(set.Contains(s.Substring(i)) && CanBreak(s.Substring(0,i), set))
            {
                return true;
            }
        }
        
        return false;
    }
}