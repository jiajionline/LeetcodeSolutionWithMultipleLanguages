public class Solution {
    public IList<IList<string>> Partition(string s) {
        var dp = new bool[s.Length, s.Length];
        var ans = new List<IList<string>>();
        DFS(s, 0, new List<string>(), ans, dp);
        return ans;
        
    }
    
    private void DFS(string s, int index, List<string> list, List<IList<string>> ans, bool[,] dp)
    {
        if(index == s.Length)
        {
            ans.Add(new List<string>(list));
            return;
        }
        
        for(int i=index;i<s.Length;i++)
        {
            if(IsPalindrome(s, index, i, dp))
            {
                dp[index,i] = true;
                list.Add(s.Substring(index, i - index + 1));
                DFS(s, i+1, list, ans, dp);
                list.RemoveAt(list.Count - 1);
            }
        }
    }
    
    private bool IsPalindrome(string s, int l, int r, bool[,] dp)
    {
        if(s[l] == s[r] && (r-l <=2 || dp[l+1,r-1])) return true;
        return false;
    }
}