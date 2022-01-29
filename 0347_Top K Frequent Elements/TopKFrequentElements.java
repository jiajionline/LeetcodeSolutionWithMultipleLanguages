class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int v: nums) {
          count.put(v, count.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
          pq.add(n);
          if (pq.size() > k) pq.poll();    
        }

        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}