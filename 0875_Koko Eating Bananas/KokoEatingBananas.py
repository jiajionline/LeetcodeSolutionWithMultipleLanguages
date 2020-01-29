class Solution(object):
    def minEatingSpeed(self, piles, H):
        """
        :type piles: List[int]
        :type H: int
        :rtype: int
        """
        l = 1
        r = max(piles)+1
        while l < r:
            m = l + (r - l)//2
            h = 0
            for p in piles:
                h += p/m
                if p % m != 0:
                    h += 1
            if h <= H:
                r = m
            else:
                l = m + 1
        return l
