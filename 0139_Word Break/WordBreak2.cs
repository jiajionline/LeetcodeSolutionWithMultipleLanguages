public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        var set = new HashSet<string>(wordDict);
        var dict = new Dictionary<string, bool>();
        
        return WordBreak(s, set, dict);
    }
    
    private bool WordBreak(string s, HashSet<string> set, Dictionary<string, bool> dict)
    {
        if(dict.ContainsKey(s)) return dict[s];
        if(set.Contains(s)){
            dict.Add(s,true);
            return true;
        }
        
        for(int i=1;i<s.Length;i++){
            var a = s.Substring(i);
            var b = s.Substring(0,i);
            if(WordBreak(b, set, dict) && set.Contains(a)){
                dict.Add(s,true);
                return true;
            }
        }
        
        dict.Add(s,false);
        return false;
    }
}