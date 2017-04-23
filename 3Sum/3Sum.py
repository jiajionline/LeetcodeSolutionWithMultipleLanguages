class ThreeSum(object):
    def threeSum(self, nums):
        ret = []
        if nums == None or len(nums) <= 2 :
            return ret
        nums.sort()
        uniqueResultSet = set()
        
        for i in range(len(nums)):
            a1 = nums[i]
            if i>0 and nums[i] == nums[i-1]:
                continue
            left = i+1
            right = len(nums)-1
            while(left < right):
                if  a1 + nums[left] + nums[right] == 0:
                    s = str(a1) + str(nums[left]) + str(nums[right])
                    if s not in uniqueResultSet:                        
                        ret.append([a1,nums[left],nums[right]])
                        uniqueResultSet.add(s)                        
                    left = left+1
                    right = right-1
                    
                elif a1 + nums[left] + nums[right] < 0:
                    left = left+1
                else:
                    right= right-1          
        
        return ret      
    
      
        
        