class Solution {
    public int[] findBuildings(int[] heights) {
        if(heights == null || heights.length == 0) return new int[0];
        Stack<Integer> stack = new Stack();
        for(int i=heights.length-1;i>=0;i--) {
            if(stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }
        
        int[] ans = new int[stack.size()];
        for(int i=0;i<ans.length;i++) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}