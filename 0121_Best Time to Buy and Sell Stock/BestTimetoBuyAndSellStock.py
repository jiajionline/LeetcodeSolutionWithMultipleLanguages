class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        @cache
        def dp(i: int) -> Tuple[int,int]:
            """Returns 1) Max profit from [0..i], 2) Min price of prices[0..i]."""
            # base case, if do nothing, the profit is 0 (min profit)
            if i < 0: return 0, 10**9
            profit, price = dp(i-1)
            # 1. do nothing, just return lst profit, or 2. sell as prices[i], the profit is prices[i] - price
            return max(profit, prices[i] - price), min(price, prices[i])
        
        return dp(len(prices)-1)[0]
        