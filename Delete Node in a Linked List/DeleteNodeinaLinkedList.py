class DeleteNodeinaLinkedList(object):
    def deleteNode(self, node):
        if node is None or node.next is None:
            return
        nextNode = node.next
        node.next = nextNode.next
        node.val = nextNode.val    