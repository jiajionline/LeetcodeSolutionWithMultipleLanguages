class Solution(object):
    def largestValues(self, root):
        currentLargestValueDict = dict()
        self.DFS(root,1,currentLargestValueDict)
        ret = list()
        for i in range(0,len(currentLargestValueDict)):
            ret.append(currentLargestValueDict[i+1])
        return ret
    
    def DFS(self,node,level,largestValueDict):
        if node is None:
            return
        if level in largestValueDict:
            largestValueDict[level] = max(node.val, largestValueDict[level])
        else:
            largestValueDict[level] = node.val
        self.DFS(node.left, level+1, largestValueDict)
        self.DFS(node.right, level+1, largestValueDict)