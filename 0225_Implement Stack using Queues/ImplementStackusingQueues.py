class MyStack(object):

    def __init__(self):
        self.current = list()
        self.backup = list()

    def push(self, x):
        self.current.append(x)
        
    def pop(self):
        self.adjust()
        return self.current.pop()

    def top(self):
        self.adjust()
        return self.current[0]
        
    def empty(self):
        return len(self.current) + len(self.backup) == 0
    
    def adjust(self):
        if self.empty():
            return
        if len(self.current) == 0:
            temp = self.current
            self.current = self.backup
            self.backup = temp
        while len(self.current) > 1:
            self.backup.append(self.current.pop(0))
            
            