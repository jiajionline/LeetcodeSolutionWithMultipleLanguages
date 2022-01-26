class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(')
                stack.add(i);
            else if(ch == ')') {
                if(stack.size()>0 && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.add(i);
            }
        }
        
        if(stack.size() == 0) return s;
        char[] chars = new char[s.length() - stack.size()];
        int index = chars.length - 1;
        
        for(int i= s.length() - 1;i>=0;i--) {
            if(stack.size() > 0 && i == stack.peek())
                stack.pop();
            else
                chars[index--] = s.charAt(i);
        }
        
        return new String(chars);
    }
}