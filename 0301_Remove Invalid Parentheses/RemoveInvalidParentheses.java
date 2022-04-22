class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        // compute the minimal number to remove unbalanced bracket
        for(char c : s.toCharArray()) {
            if(c == '(') {
                l++;
            }else if(c == ')') {
                if(l == 0) r++;
                else {
                    l--;
                }
            }
        }
        
        List<String> ans = new ArrayList<String>();
        DFS(s, 0, l , r, ans);
        return ans;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') count++;
            else if(c == ')') count--;
            if(count < 0) return false;
        }
        
        return count == 0;
    }
    
    private void DFS(String s, int index,  int l , int r, List<String> ans) {
        if(l == 0 && r == 0) {
            if(isValid(s)) ans.add(s);
            return;
        }
        
        for(int i=index;i<s.length();i++) {
            if(i > index && s.charAt(i) == s.charAt(i-1)) continue;
            if(s.charAt(i) == '(' || s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                String curr = sb.toString();
                if(r > 0 && s.charAt(i) == ')')
                    DFS(curr, i, l , r-1, ans);
                else if(l > 0 && s.charAt(i) == '(')
                    DFS(curr, i, l-1, r, ans);
            }
        }
    }
}