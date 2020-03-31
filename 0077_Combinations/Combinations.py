class Solution(object):
    def combine(self, n, k):
        def DFS(n,k,s,curr,ans):
            if len(curr) == k:
                ans.append(curr[:])
                return
            for i in range(s,n+1):
                curr.append(i)
                DFS(n,k,i+1,curr,ans)
                curr.pop()
        
        ans = []
        DFS(n,k,1,[],ans)
        return ans