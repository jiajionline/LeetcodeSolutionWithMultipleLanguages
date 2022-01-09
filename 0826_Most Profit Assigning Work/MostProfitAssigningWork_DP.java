class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int max = 100000;
        int[] diffToMaxProfits = new int[max+1];
        
        for(int i=0;i<n;i++)
            diffToMaxProfits[difficulty[i]] = Math.max(diffToMaxProfits[difficulty[i]], profit[i]);
        
        for(int i=1;i<=max;i++)
            diffToMaxProfits[i] = Math.max(diffToMaxProfits[i-1], diffToMaxProfits[i]);
        
        int ans = 0;
        for(int level : worker)
             ans += (level > max ? diffToMaxProfits[max] : diffToMaxProfits[level]);
        
        return ans;
        
    }
}