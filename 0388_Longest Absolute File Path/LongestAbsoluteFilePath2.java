class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for(String s : input.split("\n")){
            int level = s.lastIndexOf("\t")+1; 
            while(level+1<stack.size()) stack.pop();
            int len = stack.peek() + s.length()-level+1;
            stack.push(len);
            if(s.contains(".")) ans = Math.max(ans, len-1); 
        }
        return ans;
    }
}