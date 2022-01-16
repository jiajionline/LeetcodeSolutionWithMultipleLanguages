public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        var ans = new List<int>();
        int m = s.Length, n = p.Length;
        if(m < n) return ans;
        var count = new int[26];
        
        for(int i=0;i<n;i++)
        {
            count[p[i]-'a']++;
            count[s[i]-'a']--;
        }
        
        if(AllZeros(count))
            ans.Add(0);
        
        for(int i=n;i<m;i++)
        {
            count[s[i]-'a']--;
            count[s[i-n]-'a']++;
            if(AllZeros(count))
                ans.Add(i-n+1);
        }
        
        return ans;
    }
    
    private bool AllZeros(int[] count)
    {
        return count.Where(c => c!=0).Count() == 0;
    }
}