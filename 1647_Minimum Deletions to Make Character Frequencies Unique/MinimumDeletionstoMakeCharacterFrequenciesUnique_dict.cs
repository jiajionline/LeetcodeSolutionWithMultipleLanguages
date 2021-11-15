public class Solution {
    public int MinDeletions(string s) {
        var count = new int[26];
        foreach(var c in s)
            count[c - 'a']++;
        
        var ans = 0;
        var set = new HashSet<int>();
        
        for(int i=0;i<count.Length;i++)
        {
            while(count[i] > 0 && !set.Add(count[i]))
            {
                count[i]--;
                ans++;
            }
        }
        
        return ans;
    }
}