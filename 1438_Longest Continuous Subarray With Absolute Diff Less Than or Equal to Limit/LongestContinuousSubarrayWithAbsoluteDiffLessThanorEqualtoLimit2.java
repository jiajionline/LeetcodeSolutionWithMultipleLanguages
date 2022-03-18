class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //max monotonic stack 
        Deque<Integer> maxQ = new LinkedList();
        //min monotonic stack
        Deque<Integer> minQ = new LinkedList();
        
        int l = 0;
        int ans = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[r]) {
                maxQ.pollLast();
            }
            
            while(!minQ.isEmpty() && minQ.peekLast() > nums[r]) {
                minQ.pollLast();
            }
            
            maxQ.addLast(nums[r]);
            minQ.addLast(nums[r]);
            
            if (maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (nums[l] == maxQ.peekFirst()) {
                    maxQ.pollFirst();
                }
                if (nums[l] == minQ.peekFirst()) {
                    minQ.pollFirst();
                }
                l++;
            }
            
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}