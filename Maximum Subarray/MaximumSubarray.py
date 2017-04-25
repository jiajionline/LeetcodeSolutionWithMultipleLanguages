class MaximumSubarray(object):
    def maxSubArray(self, nums):
        if len(nums) == 1:
            return nums[0]
        currentMax = nums[0]
        lastMax = nums[0]
        for i in range(1,len(nums)):
            if lastMax<0:
                lastMax = nums[i]
            else:
                lastMax += nums[i]
            currentMax = max(currentMax,lastMax)
        return currentMax