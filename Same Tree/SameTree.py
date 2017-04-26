class SameTree(object):
    def isSameTree(self, p, q):
        if p is None and q is None:
            return True
        if (p is not None and q is None) or (p is None and q is not None):
            return False
        if p.val == q.val:
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
        return False