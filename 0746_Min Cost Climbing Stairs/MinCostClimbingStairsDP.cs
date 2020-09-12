public class Solution {
    public int MinCostClimbingStairs(int[] cost) {
        if(cost.Length == 1) return cost[0];
        if(cost.Length == 2) return Math.Min(cost[0], cost[1]);
        int prev2 = cost[0];
        int prev1 = cost[1];
        int curr = 0;
        for(int i=2;i< cost.Length;i++){
            curr = Math.Min(prev2, prev1) + cost[i];
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.Min(prev1, prev2);
    }
}