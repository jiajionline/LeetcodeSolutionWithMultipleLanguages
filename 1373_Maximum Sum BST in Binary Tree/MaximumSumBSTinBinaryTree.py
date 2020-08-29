# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxSumBST(self, root: TreeNode) -> int:
        # return a tuple : (leftChildMaxValue, rightChildMinValue, totolSumForThisNode, isBST)
        def dfs(node):
            if not node: return (1e9, -1e9, 0, True)    
            lLow, lHigh, lSum, lIsBST = dfs(node.left)
            rLow, rHigh, rSum, rIsBST = dfs(node.right)
            valid = lIsBST and rIsBST and node.val > lHigh and node.val < rLow
            sum = lSum + rSum + node.val if valid else -1
            self.ans = max(self.ans, sum)
            return (min(node.val,lLow), max(node.val,rHigh),sum, valid)
        self.ans = 0
        dfs(root)
        return self.ans
