public class Solution {
    public int CoinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return CoinChange(coins, amount, new int[amount+1]);
    }
    
    private int CoinChange(int[] coins, int amount, int[] memo)
    {
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(memo[amount-1] != 0) return memo[amount-1];
        int min = int.MaxValue;
        foreach(var coin in coins) {
            int result = CoinChange(coins, amount - coin, memo);
            if(result >= 0 && result < min)
                min = result + 1;
        }
        
        memo[amount-1] = (min == int.MaxValue) ? -1 : min;
        return memo[amount-1];
    }
}