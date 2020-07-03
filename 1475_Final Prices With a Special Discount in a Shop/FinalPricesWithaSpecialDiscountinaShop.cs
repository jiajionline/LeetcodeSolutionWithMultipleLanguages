public class Solution {
    public int[] FinalPrices(int[] prices) {
        for(int i=0;i<prices.Length;i++){
            for(int j=i+1;j<prices.Length;j++){
                if(prices[i] >= prices[j]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}