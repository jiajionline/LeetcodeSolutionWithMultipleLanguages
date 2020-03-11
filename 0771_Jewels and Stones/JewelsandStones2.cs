public class Solution {
    public int NumJewelsInStones(string J, string S) {
        int ans = 0;
        if(String.IsNullOrEmpty(J) || String.IsNullOrEmpty(S)) return ans;
        var set = new HashSet<char>();
        foreach (var c in J)
        {
            set.Add(c);
        }

        foreach(var c in S){
            if(set.Contains(c)) ans++;
        }
        
        return ans;
    }
}