class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) return false;
        
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int pIndex = 0;
        
        for(int v : pushed) {
            stack.push(v);
            while(!stack.isEmpty() && pIndex < n && stack.peek() == popped[pIndex]) {
                stack.pop();
                pIndex++;
            }
        }
        
        return pIndex == n;
    }
}