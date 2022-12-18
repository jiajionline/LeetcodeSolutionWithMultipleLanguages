class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n <= k) return "0";
        Stack<Character> stack = new Stack<>();
        
        for(char c : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && c < stack.peek()){
                k--;
                stack.pop();
            }
            
            stack.push(c);
        }
        
        while(k-- > 0) stack.pop();
        
        boolean leadingZero = true;
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            if(c == '0' && leadingZero) continue;
            leadingZero = false;
            sb.append(c);
        }
        
        return sb.length() == 0 ? "0" : sb.toString(); 
    }
}