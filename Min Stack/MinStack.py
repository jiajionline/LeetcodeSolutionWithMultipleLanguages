class MinStack(object):

    def __init__(self):
        self.stack = list()
        self.minStack = list()
        
    def push(self, x):
        self.stack.append(x)
        if len(self.minStack) == 0 or self.minStack[len(self.minStack) - 1] >=x:
            self.minStack.append(x)
        

    def pop(self):
        if len(self.stack) ==0:
            return None
        
        v = self.stack.pop()
        if v == self.minStack[len(self.minStack) -1]:
            self.minStack.pop()

    def top(self):
        return self.stack[len(self.stack) -1]

    def getMin(self):
        return self.minStack[len(self.minStack)-1]