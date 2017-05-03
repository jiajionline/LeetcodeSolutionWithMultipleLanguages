class RemoveDuplicatesfromSortedList(object):
    def deleteDuplicates(self, head):
        if head is None or head.next is None:
            return head
        current = head
        while current is not None:
            nextNode = current.next
            while nextNode is not None and nextNode.val == current.val:
                nextNode = nextNode.next
            current.next = nextNode
            current = nextNode
        return head