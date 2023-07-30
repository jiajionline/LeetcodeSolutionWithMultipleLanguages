class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new HashMap<Integer, Integer>());
    }

    //coinChange - minimum number of coins needed to make change for amount using coin denominations
    private int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        // amount < 0 means no solution, impossible
        if(amount < 0) return -1;
        // amount == 0 means need 0 coin
        if(amount == 0) return 0;
        if(memo.containsKey(amount)) return memo.get(amount);
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = coinChange(coins, amount - coin, memo);
            if(res >= 0 && res < min) 
                min = res + 1;
        }

        if(min == Integer.MAX_VALUE) {
            memo.put(amount, -1);
        }else{
            memo.put(amount, min);
        }

        return memo.get(amount);
    }
}