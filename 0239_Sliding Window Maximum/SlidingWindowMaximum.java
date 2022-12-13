class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new int[0];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int index = 0;
        
        for(int i=0;i<n;i++) {
            while(!queue.isEmpty() && i - queue.peekFirst() >= k) queue.pollFirst();
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            queue.addLast(i);
            if(i+1 >= k) ans[index++] = nums[queue.peekFirst()];
        }
        
        return ans;
    }
}