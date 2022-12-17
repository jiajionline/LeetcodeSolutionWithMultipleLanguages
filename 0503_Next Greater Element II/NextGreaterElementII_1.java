class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] newNums = new int[nums.length * 2];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        System.arraycopy(nums, 0, newNums, nums.length, nums.length);
        Stack<Integer> stack = new Stack<>();
        
        int[] greatElements = new int[newNums.length];
        
        for(int i=newNums.length-1;i>=0;i--) {
            while(!stack.isEmpty() && newNums[i] >= stack.peek()) stack.pop();
            greatElements[i] = stack.isEmpty() ? -1 : stack.peek() ;
            stack.push(newNums[i]);
        }
        
        int[] ans = new int[nums.length];
        System.arraycopy(greatElements, 0, ans, 0, newNums.length/2);
        
        return ans;
    }
}