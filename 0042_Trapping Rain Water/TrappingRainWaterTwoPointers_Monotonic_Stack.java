class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<height.length;i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int prev = stack.pop();
                if(stack.isEmpty()) break; // no left wall
                int h = Math.min(height[stack.peek()], height[i]) - height[prev];
                int w = i - stack.peek() - 1;
                ans += h * w;
            }
            stack.push(i);
        }
        return ans;
    }
}