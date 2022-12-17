class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        
        Stack<Integer> stack = new Stack<>();
        nextGreaterElements(nums, stack, ans);
        nextGreaterElements(nums, stack, ans);
        return ans;
    }
    
    private void nextGreaterElements(int[] nums, Stack<Integer> stack, int[] ans){
        for(int i=nums.length-1;i>=0;i--) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
    }
}