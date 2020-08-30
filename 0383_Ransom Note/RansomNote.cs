public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        if(string.IsNullOrEmpty(ransomNote)) return true;
        var dict = new Dictionary<char,int>();
        foreach (var c in ransomNote)
        {
            if(!dict.ContainsKey(c)) dict.Add(c,0);
            dict[c] +=1;
        }        

        foreach(var c in magazine){
            if(dict.ContainsKey(c)){
                dict[c] -=1;
                if(dict[c] == 0) dict.Remove(c);
                if(dict.Count == 0) return true;
            }
        }

        return false;
    }
}