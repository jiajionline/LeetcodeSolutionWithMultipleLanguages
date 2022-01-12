class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        @cache
        def dp(i:int) -> Tuple[int,int,int]:
            """
            Returns: 
            1) sold: Max profit without holding, but can't buy, can't sell
            2) holding: Max profit with holding, but can't buy, can sell
            3) cooldown: Max profit without holding, can buy but can't sell since no stock 
            """
            if i < 0: return -10**9, -10**9,0
            sold, holding, cooldown = dp(i-1)
            
            return (holding + prices[i], # sold
                    max(holding, cooldown - prices[i]), # do nothing, buy
                    max(cooldown, sold)) # do nothing, sold
        
        return max(dp(len(prices)-1))