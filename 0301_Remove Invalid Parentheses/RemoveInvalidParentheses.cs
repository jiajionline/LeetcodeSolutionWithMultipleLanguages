public class Solution {
    public IList<string> RemoveInvalidParentheses(string s) {
        var l = 0;
        var r = 0;
        // compute the minimal number to remove unbalanced bracket
        foreach(var c in s)
        {
            // if found '(' , let l++
            if(c == '(') l++;
            // if found ')'
            else if(c == ')')
            {
                // the ')' is invalid if l is 0
                if(l == 0) r++;
                else l--; 
            }
        }
        // l and r could possibly be greater than 1 like
        // ")()()("  l is 1 and r is 1 
        // "((((()))" l is 2 and r is 0
        // "()())()" l is 0 and r is 1
        
        var ans = new List<string>();
        DFS(s, 0, l , r, ans);
        return ans;
    }
    
    private bool IsValid(string s)
    {
        var count = 0;
        foreach(var c in s)
        {
            if(c == '(') count++;
            if(c == ')') count--;
            if(count < 0) return false;
        }
        
        return count == 0;
    }
    
    // l and r means the number of '(' or ')' to remove 
    private void DFS(string s, int index, int l , int r, List<string> ans)
    {
        if(l == 0 && r == 0)
        {
            if(IsValid(s)) ans.Add(s);
            return;
        }
        
        for(int i=index;i<s.Length;i++)
        {
            if(i > index && s[i] == s[i-1]) continue;
            if(s[i] == '(' || s[i] == ')')
            {
                var curr = s.Remove(i,1);
                if(r > 0 && s[i] == ')') 
                    // still pass i , since the last s[i] has been removed from s 
                    // the new string curr is passed into the new DFS
                    DFS(curr, i, l , r-1, ans);
                else if(l > 0 && s[i] == '(') 
                    DFS(curr, i, l-1, r, ans);
            }
        }
    }
}