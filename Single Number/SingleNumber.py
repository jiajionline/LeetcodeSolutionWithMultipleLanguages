class SingleNumber(object):
    def singleNumber(self, nums):
        ret = 0
        for i in nums:
            ret ^= i
        return ret