class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generate(new char[n*2], 0, 0, n, ans);
        return ans;
    }
    
    private void generate(char[] chars,  int l , int r, int n, List<String> ans)
    {
        if(l == n && r == n)
        {
            ans.add(new String(chars));
            return;
        }
        
        if(l < n)
        {
            chars[l + r] = '(';
            generate(chars,  l+1, r,n, ans);
        }
        
        if(r < l)
        {
            chars[l + r] = ')';
            generate(chars,  l, r+1, n, ans);
        }
    }
}