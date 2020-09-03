class MyCalendarTwo:
 
    def __init__(self):
        self.booked_ = []
        self.overlaps_ = []
 
    def book(self, start, end):
        for s, e in self.overlaps_:
            if start < e and end > s: return False
        
        for s, e in self.booked_:            
            if start < e and end > s: 
                self.overlaps_.append([max(start, s), min(end, e)])
        
        self.booked_.append([start, end])
        return True