public class Solution {
    private Dictionary<int, Tuple<int,int>> dict = new Dictionary<int, Tuple<int,int>>();
    public int MaxProfit(int[] prices, int fee) {
        return DP(prices, fee, prices.Length-1).Item1;
    }
    
    private Tuple<int,int> DP(int[] prices, int fee, int i)
    {
        // the inital balance should be a negative number, but not int.MinValue, otherwise , it overflows.
        if(i < 0) return Tuple.Create(0, -100000);
        if(dict.ContainsKey(i)) return dict[i];
        
        var lastDay = DP(prices, fee, i-1);
        var profit = lastDay.Item1;
        var balance = lastDay.Item2;
        
        var result = Tuple.Create(Math.Max(profit, balance + prices[i] -fee),  // do nothing , sell
                                  Math.Max(balance, profit - prices[i]));   // do nothing, buy
        dict.Add(i, result);
        return result;
    }
}