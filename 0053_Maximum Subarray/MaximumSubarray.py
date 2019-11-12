class Solution(object):
    def maxSubArray(self, nums):
        if not nums or len(nums) == 0:return 0
        if len(nums) == 1:
            return nums[0]
        ans = nums[0]
        lastMax = nums[0]
        for i in range(1,len(nums)):
            if lastMax<0:
                lastMax = nums[i]
            else:
                lastMax += nums[i]
            ans = max(ans,lastMax)
        return ans