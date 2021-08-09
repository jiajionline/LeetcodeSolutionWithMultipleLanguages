public class Solution {
    public string MinWindow(string s, string t) {
        if(string.IsNullOrEmpty(s) || string.IsNullOrEmpty(t) || s.Length < t.Length) return "";
        var dict = new Dictionary<char,int>();
        foreach(var c in t)
        {
            if(!dict.ContainsKey(c)) dict.Add(c,0);
            dict[c] += 1;
        }
        
        var l = 0;
        var r = 0;
        var minLeft = -1;
        var minLength = s.Length + 1;
        int count = 0;
        
        while(r < s.Length)
        {
            if(dict.ContainsKey(s[r])){
                dict[s[r]] -= 1;
                if(dict[s[r]] >=0) count++;
            }
            
            while(count == t.Length)
            {
                if(r - l + 1 < minLength){
                    minLeft = l;
                    minLength = r - l + 1;
                }
                
                if(dict.ContainsKey(s[l])){
                    dict[s[l]] += 1;
                    if(dict[s[l]] > 0)
                        count--;
                }
                
                l++;
            }
            r++;
        }
        
        return minLeft == -1 ? "" : s.Substring(minLeft, minLength);
    }
}