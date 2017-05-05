class MajorityElement(object):
    def majorityElement(self, nums):
        current = -1
        count = 0
        for i in range(0, len(nums)):
            if count == 0:
                current = nums[i]
                count +=1
            elif current == nums[i]:
                count +=1
            else:
                count -=1
            if count > len(nums)/2:
                break
        return current