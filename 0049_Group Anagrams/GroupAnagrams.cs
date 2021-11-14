public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        var dict = new Dictionary<string, IList<string>>();
        
        foreach(var s in strs)
        {
            var s_arr = s.ToCharArray();
            Array.Sort(s_arr);
            var new_s = new string(s_arr);
            if(!dict.ContainsKey(new_s)) dict.Add(new_s, new List<string>());
            dict[new_s].Add(s);
        }
        
        return dict.Values.ToList();
    }
}