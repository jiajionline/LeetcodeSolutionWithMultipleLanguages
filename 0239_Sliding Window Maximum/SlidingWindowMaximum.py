from collections import deque
class Solution:
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return []
        if k == 0:
            return nums

        indices = deque()
        ans = [0] * (len(nums)-k+1)

        for i in range(len(nums)):
            while len(indices) != 0 and nums[i] > nums[indices[-1]]:
                    indices.pop()
                
            indices.append(i)
            if (i - k + 1 >= 0):ans[i - k + 1] = nums[indices[0]]       
            if (i - k + 1 == indices[0]):indices.popleft()
        
        return ans