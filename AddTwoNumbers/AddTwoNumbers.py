from ListNode import ListNode

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        if l1 == None or l2 == None:
            return None
        preHead = ListNode(-1)
        current = preHead
        p1 = l1
        p2 = l2
        carry = 0
        
        while p1 or p2 or carry>0:
            value = 0
            if p1:
                value+=p1.val
                p1 = p1.next
            if p2:
                value+=p2.val
                p2 = p2.next
            value += carry
            carry = value / 10
            value = value % 10
            temp = ListNode(value)
            current.next = temp
            current = temp        
        return preHead.next        