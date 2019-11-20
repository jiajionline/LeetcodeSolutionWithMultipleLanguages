from collections import defaultdict
class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        def calc(n, dict):
            if n in dict:
                return dict[n]
            else:
                sum = 0
                for root in range(1,n+1):
                    left = calc(root-1,dict)
                    right = calc(n-root,dict)
                    sum += left * right
                dict[n] = sum
                return sum
        
        dict = defaultdict(int)
        dict[0] = 1
        dict[1] = 1
        return calc(n,dict)            