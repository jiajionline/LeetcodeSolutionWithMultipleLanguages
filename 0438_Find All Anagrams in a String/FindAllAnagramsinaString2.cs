public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        var ans = new List<int>();
        var start = 0;
        var end = 0;
        
        var p_arr = new int[26];
        foreach(var c in p)
            p_arr[c-'a']++;
        
        var s_arr = new int[26];
        
        while(end < s.Length)
        {
            s_arr[s[end++]-'a']++;
            if(end - start < p.Length)
            {
                continue;
            }
            else
            {
               if(Identical(s_arr,p_arr)) ans.Add(start); 
               s_arr[s[start++]-'a']--;     
            }
        }
        
        return ans;
    }
    
    private bool Identical(int[] s_arr, int[] p_arr)
    {
        for(int i=0;i<s_arr.Length;i++)
        {
            if(s_arr[i] != p_arr[i]) return false;
        }
        
        return true;
    }
}