# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        def traverse(node):
            if not node:return (None,0)
            leftNode, leftH = traverse(node.left)
            rightNode, rightH = traverse(node.right)
            if(leftH == rightH):
                return (node, leftH+1)
            elif(leftH > rightH):
                return (leftNode, leftH+1)
            else:
                return (rightNode, rightH+1)
        
        return traverse(root)[0]
