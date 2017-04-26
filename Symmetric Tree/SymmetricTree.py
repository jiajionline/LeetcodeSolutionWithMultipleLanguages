class SymmetricTree(object):
    def isSymmetric(self, root):
        return self.isSame(root, root)
    
    def isSame(self,left,right):    
        if left is None and right is None:
            return True
        if left is not None and right is not None:
            return left.val == right.val and self.isSame(left.left, right.right) and self.isSame(left.right, right.left)
        return False
    
    def isSymmetricIteration(self, root):
        if root is None:
            return True
        queue = list()
        queue.append(root)
        queue.append(root)
        
        while len(queue)>0:
            left = queue.pop()
            right = queue.pop()
            if left == None and right == None:
                continue
            if left == None or right == None:
                return False
            if left.val == right.val:
                queue.append(left.left)
                queue.append(right.right)
                queue.append(left.right)
                queue.append(right.left)
            else:
                return False
        return True
    
    