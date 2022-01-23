public class Solution {
    public bool IsSubsequence(string s, string t) {
        if(string.IsNullOrEmpty(s)) return true;
        if(string.IsNullOrEmpty(t)) return false;
        
        var dict = new Dictionary<char, List<int>>();
        for(int i=0;i<t.Length;i++)
        {
            if(!dict.ContainsKey(t[i])) dict.Add(t[i], new List<int>());
            dict[t[i]].Add(i);
        }
        
        var currMatchIdx = -1;
        foreach(var ch in s)
        {
            if(!dict.ContainsKey(ch)) return false;
            
            var isMatched = false;
            foreach(var idx in dict[ch])
            {
                if(currMatchIdx < idx) {
                    currMatchIdx = idx;
                    isMatched = true;
                    break;
                }
            }
            
            if(!isMatched) return false;
        }
        
        return true;
    }
}