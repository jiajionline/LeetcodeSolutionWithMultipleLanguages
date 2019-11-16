import collections
from typing import List

class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if not points:return 0
        if len(points) <= 2:
            return len(points)

        def getGCD(a, b):
            if a == 0:
                return b
            return getGCD(b % a, a)
        
        ans = 0
        for i in range(len(points)):
            dic = collections.defaultdict(int)
            localMax, overlap = 0, 0
            for j in range(i+1, len(points)):
                dx = points[j][0] - points[i][0]
                dy = points[j][1] - points[i][1]
                #same points means overlap++
                if dx == 0 and dy == 0:
                    overlap += 1
                    continue
                gcd = getGCD(dx, dy)
                slope = str(dx//gcd) + '_' + str(dy//gcd) 
                dic[slope] += 1
                localMax = max(localMax, dic[slope])
                #+1 means itself, think about if the input only has 1 point, you need to return 1
            ans = max(ans, localMax+overlap+1)
        return ans
                