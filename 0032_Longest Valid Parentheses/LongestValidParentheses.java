class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else{
                if(stack.size() > 0 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    ans = Math.max(ans, i - (stack.empty() ? -1 : stack.peek()));
                }else{
                    stack.push(i);
                }
            }
        }
        
        return ans;
    }
}