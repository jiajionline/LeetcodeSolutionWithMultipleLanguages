class Solution {
    private int[] prefixSum;
    private int sum;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        for(int i=0;i<w.length;i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }
    
    public int pickIndex() {
        double target = sum * Math.random();
        int l = 0, r = prefixSum.length;
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(prefixSum[mid] > target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */