class RemoveElement(object):
    def removeElement(self, nums, val):
        if nums is None or len(nums) == 0:
            return 0
        currentIndex = -1
        nextIndex = 0
        while nextIndex < len(nums):
            if nums[nextIndex] != val:
                currentIndex +=1
                nums[currentIndex] = nums[nextIndex]
            nextIndex+=1
        return currentIndex + 1