class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height or len(height) <= 1:return 0
        left = 0
        right = len(height) - 1
        ans = 0
        while left < right:
            ans = max(ans,min(height[left], height[right]) * (right - left))
            if height[left] > height[right]:
                right -= 1
            else:
                left += 1
        return ans
