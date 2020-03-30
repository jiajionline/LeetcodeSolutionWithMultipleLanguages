class Solution(object):
    def combinationSum3(self, k, n):
        def DFS(k,n,s,curr,ans):
            if n == 0:
                if len(curr) == k:ans.append(curr[:])
                return
            for j in range(s,10):
                if j > n:break
                curr.append(j)
                DFS(k,n-j,j+1,curr,ans)
                curr.pop()
        ans = []
        DFS(k,n,1,[],ans)
        return ans