//cache + brute force
public class Solution {
    private Dictionary<string,bool> cache = new Dictionary<string,bool>();

    public int NumMatchingSubseq(string s, string[] words) {
      var ans = 0;
      foreach(var w in words)
      {
          if(cache.ContainsKey(w)){
            ans = cache[w] ? ans+1 : ans;
            continue;
          }

          var result = IsSubsequence(w, s);
          ans = result ? ans+1 : ans;
          cache.Add(w, result);
      }    

      return ans;
    }

    private bool IsSubsequence(string s, string t) {
        if(string.IsNullOrEmpty(s)) return true;
        if(string.IsNullOrEmpty(t)) return false;
        
        var indexS = 0;
        var indexT = 0;
        
        while(indexS < s.Length && indexT < t.Length)
        {
            while(indexT < t.Length && t[indexT] != s[indexS]) 
                indexT++;
            
            if(indexT < t.Length && t[indexT] == s[indexS]){
                indexT++;
                indexS++;
            }
        }
        
        return indexS == s.Length;
    }

}