class Solution {
    private int index = 0;
    private final String Operators = "+-*/)";
    public int calculate(String s) {
        int num = 0;
        char operator = '+';
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while(index < s.length()) {
            char c = s.charAt(index++);
            if(Character.isDigit(c)) num = num * 10 + (c - '0');
            
            if(c == '(') num = calculate(s);
            
            if(index >= s.length() || Operators.indexOf(c) >= 0){
                if(operator == '+') 
                    stack.push(num);
                else if(operator == '-') 
                    stack.push(-num);
                else if(operator == '*') 
                    stack.push(stack.pop() * num);
                else if(operator == '/')
                    stack.push(stack.pop() / num);
                
                operator = c;
                num = 0;
            }
            
            if(c == ')') break;
        }
        
        int ans = 0;
        for(int v : stack) ans+=v;
        return ans;
    }
}