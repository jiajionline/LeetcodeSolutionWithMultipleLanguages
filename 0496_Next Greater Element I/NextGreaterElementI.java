class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) stack.pop();
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            ans[i] = map.get(nums1[i]);
        }   
        
        return ans;
    }
}