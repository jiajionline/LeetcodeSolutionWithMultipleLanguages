class RemoveDuplicatesfromSortedArray(object):
    def removeDuplicates(self, nums):
        if nums is None or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 1
        currentIndex = 0
        nextIndex = 0
        while nextIndex < len(nums):
            if nums[currentIndex] != nums[nextIndex]:
                currentIndex = currentIndex + 1
                nums[currentIndex] = nums[nextIndex]
            nextIndex = nextIndex + 1        
        return currentIndex + 1    