class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        @cache
        def dp(i:int) -> Tuple[int,int]:
            """Returns 1. Max profit after ith day. No stock hold, can buy. 
            2. Max balance after ith day. Holding a stock, can sell"""
            if i < 0: return 0, -10**9
            profit, balance = dp(i-1)
            # For profit : 1. do nothing, just profit, or sell, the profit is balance (the money currently you have plus the profit you sell the stock)
            # For balance : 1. do nothing, or buy, when have balance means holding a stock, as this state, you can't buy a stock, you have to use profit to buy.
            return max(profit, balance + prices[i]), max(balance, profit - prices[i])
        
        return dp(len(prices)-1)[0]