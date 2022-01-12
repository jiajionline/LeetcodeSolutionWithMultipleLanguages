public class Solution {
public int MaxProfit(int[] prices)
        {
            int preHold=int.MinValue, hold = 0, preRest = 0, rest = 0, preSold = 0, sold = 0;

            for(int i = 0; i < prices.Length; i++)
            {
                rest = Math.Max(preRest, preSold);
                hold = Math.Max(preHold, preRest - prices[i]);
                sold = preHold + prices[i];

                preHold = hold;
                preRest = rest;
                preSold = sold;
            }

            return Math.Max(rest, sold);
        }
}