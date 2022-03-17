class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String t : tokens) {
            if("+-*/".contains(t)) {
                int a = stack.pop();
                int b = stack.pop();
                if(t.equals("+")) {
                    stack.push(a+b);
                }else if(t.equals("-")) {
                    stack.push(b - a);
                }else if(t.equals("*")) {
                    stack.push(b * a);
                }else {
                    stack.push((int)(b / a));
                }
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        
        return stack.pop();
    }
}