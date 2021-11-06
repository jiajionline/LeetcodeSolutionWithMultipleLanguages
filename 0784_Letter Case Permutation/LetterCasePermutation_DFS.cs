public class Solution {
    public IList<string> LetterCasePermutation(string s) {
        var list = new List<string>();
        list.Add("");
        DFS(s, 0, list);
        
        return list;
    }
    
    private void DFS(string s , int index, List<string> ans)
    {
        if(index >= s.Length) return;
        var list = new List<string>();
        
        var c = s[index];
        
        foreach(var str in ans)
        {
            if(char.IsLetter(c))
            {
                list.Add(str + char.ToUpper(c));
                list.Add(str + char.ToLower(c));
            }
            else
            {
                list.Add(str + c);
            }
        }
        
        ans.Clear();
        ans.AddRange(list);
        DFS(s, index+1, ans);
    }
}