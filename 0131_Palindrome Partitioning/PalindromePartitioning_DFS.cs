public class Solution {
    public IList<IList<string>> Partition(string s) {
        var ans = new List<IList<string>>();
        if(string.IsNullOrEmpty(s)) return ans;
        
        DFS(s, 0, new List<string>(), ans);
        return ans;
        
    }
    
    private void DFS(string s, int index, IList<string> curr, IList<IList<string>> ans)
    {
        if(s.Length == index)
        {
            ans.Add(new List<string>(curr));
            return;
        }
        
        for(int i = index;i<s.Length;i++)
        {
            if(IsPalindrome(s, index, i)){
                curr.Add(s.Substring(index, i - index + 1));
                DFS(s, i+1, curr, ans);
                curr.RemoveAt(curr.Count - 1);
            }
        }
    }
    
    private bool IsPalindrome(string str, int s, int e)
    {
        while(s < e)
        {
            if(str[s++] != str[e--]) return false;
        }
        
        return true;
    }
}