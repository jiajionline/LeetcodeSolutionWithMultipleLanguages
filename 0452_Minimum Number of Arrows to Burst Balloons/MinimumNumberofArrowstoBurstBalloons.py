class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points = sorted(points, key = lambda x : x[1])
        ans, currEnd = 0, -float('inf')
        for k in points:
            if k[0] > currEnd:
                ans +=1
                currEnd = k[1]
        
        return ans