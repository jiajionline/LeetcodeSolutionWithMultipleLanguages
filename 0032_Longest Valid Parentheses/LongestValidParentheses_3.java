class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || c == '(') {
                stack.push(i);
            }else{
                if(s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        
        int lastIndex = s.length();
        while(stack.size() > 0) {
            int index = stack.pop();
            ans = Math.max(ans, lastIndex - index - 1);
            lastIndex = index;
        }
        
        ans = Math.max(ans, lastIndex);
        
        return ans;
    }
}