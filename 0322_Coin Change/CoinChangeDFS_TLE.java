class Solution {

    private int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        coins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        DFS(coins, 0, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void DFS(int[] coins, int index, int amount, int count){
        if(amount == 0){
            ans = Math.min(ans, count);
            return;
        }

        if(index == coins.length) return;

        int coin = coins[index];
        //k + count is a pruning, since we are trying to find the count which is less than ans
        for(int k = amount/coin; k>=0 && k + count < ans;k--){
            DFS(coins, index+1,amount - k * coin,count+k);
        }
    }
}