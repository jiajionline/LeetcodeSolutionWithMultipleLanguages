class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def DFS(candidates, target,s,curr,ans):
            if target == 0:
                ans.append(curr[:])
                return
            
            for i in range(s,len(candidates)):
                if candidates[i] > target: return
                curr.append(candidates[i])
                DFS(candidates, target - candidates[i],i,curr,ans)
                curr.pop()
                
        ans = []       
        candidates.sort() 
        DFS(candidates,target,0,[],ans)
        return ans