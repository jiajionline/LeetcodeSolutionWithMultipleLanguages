class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        for(int len=2;len <=n; len+=2) {
            for(int l = 0; l <= n-len;l++) {
                int r = l + len - 1;
                
                if(isValid(s, l , r))
                    ans = Math.max(ans, len);
            }
        }
        
        return ans;
    }
    
    private boolean isValid(String s, int l, int r) {
        if((r-l+1) % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=l;i<=r;i++) {
            char ch = s.charAt(i);
            
            if(ch == ')')
            {
                if(stack.size() == 0) return false;
                stack.pop();
            }else 
                stack.push('(');
        }
        
        return stack.size() == 0;
        
    }
}