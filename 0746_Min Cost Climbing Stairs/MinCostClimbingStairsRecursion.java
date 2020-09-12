class Solution {
    // Top Down Memoization - O(n) 1ms
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
        return Math.min(minCost(cache, n-1, cost), minCost(cache, n-2, cost));
    }
    private int minCost(HashMap<Integer,Integer> cache, int n, int[] cost) {
        if (n < 0) return 0;
        if (n==0 || n==1) return cost[n];
        if (cache.containsKey(n)) return cache.get(n);
        int r = cost[n] + Math.min(minCost(cache, n-1, cost), minCost(cache, n-2, cost));
        cache.put(n,r);
        return r;
    }
}