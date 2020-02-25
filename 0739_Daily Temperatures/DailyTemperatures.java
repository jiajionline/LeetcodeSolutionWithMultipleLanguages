class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=T.length-1;i>=0;i--){
            while(stack.size() > 0 && T[i] >= T[stack.peek()]) stack.pop();
            if(stack.size() == 0){
                ans[i] = 0;
            }else{
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        
        return ans;
    }
}