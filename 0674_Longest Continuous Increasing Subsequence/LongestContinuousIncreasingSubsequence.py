class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums)==0:return 0
        if len(nums) == 1: return 1
        cnt = 1 
        ans = 1
        for i in range(1,len(nums)):
            if nums[i] > nums[i-1]:
               cnt+=1
               ans = max(ans,cnt)
            else:
               cnt=1
        return ans