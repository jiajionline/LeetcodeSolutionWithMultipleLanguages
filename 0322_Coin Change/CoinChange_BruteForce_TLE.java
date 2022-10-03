class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, 0, amount);
    }
    
    private int coinChange(int[] coins, int index, int amount) {
        if(amount == 0) return 0;
        if(amount > 0 && index < coins.length) {
            int maxCount = amount / coins[index];
            int minCost = Integer.MAX_VALUE;
            for(int x = 0;x <= maxCount; x++) {
                if(amount >= x * coins[index]) {
                    int res = coinChange(coins, index+1, amount - x * coins[index]);
                    if(res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }
}