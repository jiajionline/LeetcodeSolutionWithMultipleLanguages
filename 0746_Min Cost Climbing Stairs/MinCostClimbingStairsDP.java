class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        if(n == 2) return Math.min(cost[0], cost[1]);
        int prev2 = cost[0], prev1 = cost[1];
        for(int i=2;i<n;i++) {
            int curr = Math.min(prev2, prev1) + cost[i];
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev2, prev1);
    }
}