class ImplementQueueusingStacks(object):
    def __init__(self):
        self.enqueueStack = list()
        self.dequeueStack = list()
        

    def push(self, x):
        self.enqueueStack.append(x)
        
    def pop(self):
        self.adjust()
        return self.dequeueStack.pop()
        
    def peek(self):
        self.adjust()
        return self.dequeueStack[len(self.dequeueStack) -1]
        
    def empty(self):
        return len(self.enqueueStack) + len(self.dequeueStack) == 0
    
    def adjust(self):
        if len(self.dequeueStack)==0:
            while len(self.enqueueStack) >0:
                self.dequeueStack.append(self.enqueueStack.pop())
