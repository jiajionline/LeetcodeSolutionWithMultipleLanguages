class MaxConsecuriveOnes(object):
    def findMaxConsecutiveOnes(self, nums):
        ret = 0
        currentCount = 0
        for v in range(0,len(nums)):
            if nums[v] == 1:
                currentCount += 1
                ret = max(currentCount, ret)
            else:
                currentCount = 0
        return ret