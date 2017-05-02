class MinimumDepthofBinaryTree(object):
    def minDepth(self, root):
        if root is None:
            return 0
        if not root.left or not root.right:
            return self.minDepth(root.left) + self.minDepth(root.right) + 1
        return min(self.minDepth(root.left), self.minDepth(root.right)) + 1