from ListNode import ListNode 

class MergeTwoSortedLists(object):
    def mergeTwoLists(self, l1, l2):
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        
        preHeader = ListNode(-1)
        current = preHeader
        p1 = l1
        p2 = l2
        
        while p1 is not None and p2 is not None:
            if p1.val == p2.val:
                current.next = p1
                current = p1
                p1 = p1.next
                current.next = p2
                current = p2
                p2 = p2.next
            elif p1.val < p2.val:
                current.next = p1
                current = p1
                p1 = p1.next
            else:
                current.next = p2
                current = p2
                p2 = p2.next
        
        if p1 is not None:
            current.next = p1
        if p2 is not None:
            current.next = p2
        
        return preHeader.next