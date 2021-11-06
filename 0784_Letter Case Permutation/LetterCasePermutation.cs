public class Solution {
    public IList<string> LetterCasePermutation(string s) {
        
        var ans = new List<string>();
        ans.Add("");
        
        foreach(var c in s)
        {
            var list = new List<string>();
            
            foreach(var str in ans)
            {
                if(char.IsLetter(c))
                {
                    list.Add(str + char.ToLower(c));
                    list.Add(str + char.ToUpper(c));
                }
                else
                {
                    list.Add(str + c);
                }
            }
            
            ans = list;
        }
        
        return ans;
    }
}