public class Solution {
    public int MinDeletions(string s) {
        var count = new int[26];
        foreach(var c in s)
            count[c - 'a']++;
        
        var l = s.Length;
        var freq = new int[l+1];
        foreach(var f in count)
        {
            freq[f]++;
        }
        
        var index = freq.Length-1;
        var r = freq.Length-1;
        
        var ans = 0;
        
        while(index > 0)
        {
            if(freq[index] <= 1)
            {
                index--;
                continue;
            }
            
            while(freq[index] > 1)
            {
                var k = index - 1;
                while(k > 0 && freq[k] > 0) k--;
                
                if(k == 0){
                    ans += index;
                }else{
                    freq[k] = 1;
                    ans += (index - k);
                }
                
                freq[index]--;
            }
        }
        
        return ans;
    }
}