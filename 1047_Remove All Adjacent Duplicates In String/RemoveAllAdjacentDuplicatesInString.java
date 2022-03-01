class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() <= 1) return s;
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()) {
            if(stack.size() > 0 && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0)
            sb.insert(0, stack.pop());
        
        return sb.toString();
    }
}