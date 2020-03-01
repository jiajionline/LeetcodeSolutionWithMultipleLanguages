class Solution(object):
    def missingNumber(self, nums):
        ret = 0
        for i in range(0,len(nums)):
            ret ^= (i+1)
            ret ^= nums[i]
        return ret