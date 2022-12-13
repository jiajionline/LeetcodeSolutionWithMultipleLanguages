class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new int[0];
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] ans = new int[n - k + 1];
        
        for(int i=0;i<n;i++) {
            while(deque.size() > 0 && nums[i] >= nums[deque.getLast()])
                deque.removeLast();
            
            deque.addLast(i);
            
            if(i+1 >= k) {
                ans[i-k+1] = nums[deque.getFirst()];   
                if(i-k+1 == deque.getFirst()) deque.removeFirst();
            }
        }
        
        return ans;
    }
}