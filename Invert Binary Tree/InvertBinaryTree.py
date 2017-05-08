from _collections import deque
class InvertBinaryTree(object):
    def invertTree(self, root):
        if root is None:
            return root
        queue = deque()
        queue.append(root)
        
        while len(queue)>0:
            node = queue.popleft()
            if node.left or node.right:
                tempNode = node.left
                node.left = node.right
                node.right = tempNode
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return root