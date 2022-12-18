class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] arr = new int[n+1];
        System.arraycopy(heights,0,arr,0,n);
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<arr.length;i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int prev = stack.pop();
                int h = heights[prev];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        
        return ans;
    }
}