public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        var ans = new List<int>();
        var l_p = p.Length;
        var l_s = s.Length;
        
        if(l_s < l_p) return ans;
        var count = new int[26];
        for(int i=0;i<l_p;i++)
        {
            count[p[i]-'a']++;
            count[s[i]-'a']--;
        }
        
        if(AllZeros(count)) ans.Add(0);
        
        for(int i=l_p;i<l_s;i++)
        {
            count[s[i]-'a']--; 
            count[s[i-l_p]-'a']++;
            if(AllZeros(count))
                ans.Add(i-l_p+1);
        }
        
        return ans;
    }
    
    private bool AllZeros(int[] count)
    {
        return count.Where(c => c!=0).Count() == 0;
    }
}