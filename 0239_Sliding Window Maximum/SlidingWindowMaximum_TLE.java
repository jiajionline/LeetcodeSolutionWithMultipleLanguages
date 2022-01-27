class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new int[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] ans = new int[nums.length - k + 1];
        
        for(int i=0;i<nums.length;i++) {
            if(i >= k) {
                ans[i-k] = pq.peek();   
                pq.remove(nums[i-k]);
            }
            
            pq.add(nums[i]);
        }
        
        ans[ans.length-1] = pq.peek();
        
        return ans;
    }
}