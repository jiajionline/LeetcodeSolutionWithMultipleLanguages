class Solution {
    public int calculate(String s) {
        char sign = '+';
        int ans = 0;
        int num = 0;
        Stack<Integer> stack = new Stack();
        
        Set<Character> signSet = new HashSet() {{
            add('+');
            add('-');
            add('*');
            add('/');
        }};
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                num *= 10;
                num += (c - '0');
            }
            
            if(signSet.contains(c) || i == s.length()-1) {
                if(sign == '+') {
                    stack.push(num);
                }else if(sign == '-') {
                    stack.push(-num);
                }else if(sign == '*') {
                    stack.push(stack.pop() * num);
                }else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                sign = c;
                num = 0;
            }
        }
        
        for(int v : stack) ans += v;
        return ans;
    }
}