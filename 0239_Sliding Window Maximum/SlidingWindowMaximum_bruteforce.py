class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # TLE , but only one line code
        return nums and [max(nums[i:i+k]) for i in range(len(nums)-k+1)]