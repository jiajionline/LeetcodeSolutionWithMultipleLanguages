class Solution {
    public int calculate(String s) {
        if(s.isEmpty()) return 0;
        
        int ans = 0;
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack();
        stack.push(sign);
        
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num *= 10;
                num += (c-'0');
            }else if(c == '(') {
                stack.push(sign);
            }else if(c == ')') {
                stack.pop();
            }else if(c == '+' || c == '-') {
                ans += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            }
        }
        
        ans += sign * num;
        return ans;
    }
}