# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import List, Tuple, Dict, TextIO
 
class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        ans = []
        ds = set(to_delete)
        def process(n):
            if not n: return None
            n.left , n.right = process(n.left) , process(n.right)
            if n.val not in ds: return n
            if n.left: ans.append(n.left)
            if n.right: ans.append(n.right)
            return None
        root = process(root)
        if root: ans.append(root)
        return ans