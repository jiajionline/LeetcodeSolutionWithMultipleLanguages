class TwoSum(object):
        
    def twoSum(self, nums, target):
        ret = [-1,-1]
        if(nums is None or len(nums) <=1):
            return ret
        cache = {}
        for i in range(len(nums)):
            if target - nums[i] in cache:
                return [cache[target - nums[i]], i]
            cache[nums[i]] = i
        return ret