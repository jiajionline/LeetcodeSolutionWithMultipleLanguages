class BinaryTreeLevelOrderTraversal(object):
    def levelOrder(self, root):
        result = list()
        if root is None:
            return result
        
        currentLevel = list()
        nextLevel = list()
        currentLevel.append(root)
        
        while len(currentLevel)>0:
            currentLevelList = list()
            
            while len(currentLevel)>0:
                node = currentLevel.pop(0)
                currentLevelList.append(node.val)
                if node.left is not None:
                    nextLevel.append(node.left)
                if node.right is not None:
                    nextLevel.append(node.right)
            
            result.append(currentLevelList)
            temp = currentLevel
            currentLevel = nextLevel
            nextLevel = temp
        
        return result