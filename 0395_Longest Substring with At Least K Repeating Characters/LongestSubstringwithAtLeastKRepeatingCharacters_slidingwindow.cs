public class Solution {
    public int LongestSubstring(string s, int k) {
        var counters = new int[26];
        var maxUnique = MaxUnique(s);
        int ans = 0;
        
        for(int currUnique = 1; currUnique <= maxUnique; currUnique++)
        {
            Array.Fill(counters, 0);
            var start = 0;
            var end = 0;
            var idx = 0;
            var unique = 0;
            var countAtLeastK = 0;
            
            while(end < s.Length)
            {
                //expand the window
                if(unique <= currUnique)
                {
                    idx = s[end] - 'a';
                    if(counters[idx] == 0) unique++;
                    counters[idx]++;
                    if(counters[idx] == k) countAtLeastK++;
                    end++;
                }
                else
                {
                    //shrink the window
                    idx = s[start] - 'a';
                    if(counters[idx] == k) countAtLeastK--;
                    counters[idx]--;
                    if(counters[idx] == 0) unique--;
                    start++;
                }
                
                if(unique == currUnique && unique == countAtLeastK){
                    ans = Math.Max(ans, end - start);
                }
            }
        }
        
        return ans;
        
    }
    
    private int MaxUnique(string s)
    {
        var count = 0;
        var counters = new bool[26];
        foreach(var c in s)
        {
            if(!counters[c - 'a'])
            {
                count++;
                counters[c - 'a'] = true;
            }
        }
        
        return count;
    }
}