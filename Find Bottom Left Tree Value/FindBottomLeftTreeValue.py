from _collections import deque
class FindBottomLeftTreeValue(object):
    def findBottomLeftValue(self, root):
        queue = deque()
        queue.append(root)
        mostLeft = None
        while len(queue)>0:
            mostLeft = queue.popleft()
            if mostLeft.right is not None:
                queue.append(mostLeft.right)
            if mostLeft.left is not None:
                queue.append(mostLeft.left)
        return mostLeft.val