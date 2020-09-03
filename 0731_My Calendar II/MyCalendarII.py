class MyCalendarTwo:
 
    def __init__(self):
        self.bookList = []
        self.intersectionList = []
 
    def book(self, start, end):
        for s, e in self.intersectionList:
            if start < e and end > s: return False
        
        for s, e in self.bookList:            
            if start < e and end > s: 
                self.intersectionList.append([max(start, s), min(end, e)])
        
        self.bookList.append([start, end])
        return True