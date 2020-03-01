# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteNode(self, node):
        if node is None or node.next is None:
            return
        nextNode = node.next
        node.next = nextNode.next
        node.val = nextNode.val    