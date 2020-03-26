class Solution(object):
    def moveZeroes(self, nums):
        if(nums is None or len(nums) <=1):
            return
        currentIndex = 0
        copyIndex = 0
        while currentIndex < len(nums):
            if nums[currentIndex] != 0:
                nums[copyIndex] = nums[currentIndex]
                copyIndex += 1
            currentIndex += 1
        while copyIndex < len(nums):
            nums[copyIndex] = 0
            copyIndex += 1