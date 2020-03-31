class Solution(object):
    def subsetsWithDup(self, nums):
        def DFS(nums, n, s, curr, ans):
            if len(curr) == n:
                ans.append(curr[:])
                return
            for i in range(s,len(nums)):
                if i > s and nums[i] == nums[i-1]:continue
                curr.append(nums[i])
                DFS(nums, n, i+1, curr, ans)
                curr.pop()
        
        ans = []
        nums.sort()
        for n in range(0, len(nums)+1):
            DFS(nums, n,0, [],ans)
        
        return ans
        