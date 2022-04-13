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
        double r = sum * Math.random();
        for(int i=0;i<prefixSum.length;i++) {
            if(r < prefixSum[i]) return i;
        }
        
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */