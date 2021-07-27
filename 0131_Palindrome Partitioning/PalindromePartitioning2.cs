public class Solution {
    public IList<IList<string>> Partition(string s) {
        var ans = new List<IList<string>>();
        if(string.IsNullOrEmpty(s)) return ans;
        
        var dp = new bool[s.Length,s.Length];
        
        DFS(s, 0, dp, new List<string>(), ans);
        return ans;
        
    }
    
    private void DFS(string str, int start, bool[,] dp, IList<string> curr, IList<IList<string>> ans)
    {
        if(str.Length == start)
        {
            ans.Add(new List<string>(curr));
            return;
        }
        
        for(int end = start;end<str.Length;end++)
        {
            if(str[end] == str[start] && (end - start <=2 || dp[start+1,end-1])){
                dp[start,end] = true;
                curr.Add(str.Substring(start, end - start + 1));
                DFS(str, end+1, dp, curr, ans);
                curr.RemoveAt(curr.Count - 1);
            }
        }
    }
}