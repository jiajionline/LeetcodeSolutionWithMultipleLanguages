class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] presum = new long[n+1];
        for(int i=0;i<n;i++) {
            presum[i+1] = presum[i] + nums[i];
        }
       
        int ans = Integer.MAX_VALUE;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<=n;i++) {
            while(q.size() > 0 && presum[i] <= presum[q.peekLast()]) {
                q.removeLast();
            }
           
            while(q.size() > 0 && presum[i] - presum[q.peekFirst()] >= k) {
                ans = Math.min(ans, i - q.removeFirst());
            }
           
            q.offerLast(i);
        }
       
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}