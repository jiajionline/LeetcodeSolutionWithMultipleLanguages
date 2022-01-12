class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        @cache
        def dp(i:int) -> Tuple[int,int]:
            if i < 0: return 0, -10**9
            profit, balance = dp(i-1)
            return max(profit, balance + prices[i] - fee), max(balance, profit - prices[i])
        
        return dp(len(prices)-1)[0]