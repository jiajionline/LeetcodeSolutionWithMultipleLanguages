class Node:
  def __init__(self, val, _next=None):
    self.val = val
    self.next = _next
    
class MyLinkedList:  
  def __init__(self):
    self.head = self.tail = None
    self.size = 0
  
  def getNode(self, index):
    node = Node(0, self.head)
    for i in range(index + 1):
      node = node.next
    return node
    
  def get(self, index):
    if index < 0 or index >= self.size: return -1
    return self.getNode(index).val
 
 
  def addAtHead(self, val):
    node = Node(val, self.head)
    self.head = node
    if self.size == 0:
      self.tail = node
    self.size += 1
 
 
  def addAtTail(self, val):
    node = Node(val)
    if self.size == 0:
      self.head = self.tail = node
    else:
      self.tail.next = node
      self.tail = node
    self.size += 1
 
  def addAtIndex(self, index, val):
    if index < 0 or index > self.size: return
    if index == 0: return self.addAtHead(val)
    if index == self.size: return self.addAtTail(val)
    prev = self.getNode(index - 1)
    node = Node(val, prev.next)
    prev.next = node
    self.size += 1
 
 
  def deleteAtIndex(self, index):
    if index < 0 or index >= self.size: return
    prev = self.getNode(index - 1)
    prev.next = prev.next.next
    if index == 0: self.head = prev.next
    if index == self.size - 1: self.tail = prev
    self.size -= 1