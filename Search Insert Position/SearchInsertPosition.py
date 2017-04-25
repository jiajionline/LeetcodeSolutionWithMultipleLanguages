class SearchInsertPosition(object):
    def searchInsert(self, nums, target):
        if nums is None or len(nums) == 0:
            return 0        
        if target <= nums[0]:
            return 0
        numsLength = len(nums);
        if target > nums[numsLength-1]:
            return numsLength
        start = 0
        end = numsLength - 1
        while start <= end:
            mid = (end - start)/2 + start
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                if mid-1 >=0 and target > nums[mid-1]:
                    return mid
                end = mid
            else:
                if mid+1 <= numsLength-1 and target < nums[mid+1]:
                    return mid+1
                start = mid + 1
        return 0
        