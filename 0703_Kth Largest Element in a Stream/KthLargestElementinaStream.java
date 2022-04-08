class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for(int v : nums) {
            if(pq.size() < k) {
                pq.add(v);
            }else{
                if(pq.peek() < v) {
                    pq.poll();
                    pq.add(v);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
        }else if(pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */