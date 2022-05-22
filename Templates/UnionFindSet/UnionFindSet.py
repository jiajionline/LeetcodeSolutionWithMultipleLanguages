class UnionFindSet:
    def __init__(self, n) -> None:
        self._parents = [i for i in range(n+1)]
        self._ranks = [1 for i in range(n+1)]

    def find(self, n):
        while n != self._parents[n]:
            self._parents[n] = self._parents[self._parents[n]]
            n = self._parents[n]
        return n   
    
    def union(self, n1, n2):
        rootN1 = self.find(n1)
        rootN2 = self.find(n2)
        if rootN1 == rootN2: return False
        
        if self._ranks[rootN1] < self._ranks[rootN2]:
            self._parents[rootN1] = rootN2
        elif self._ranks[rootN1] > self._ranks[rootN2]:
            self._parents[rootN2] = rootN1
        else:        
            self._parents[rootN2] = rootN1
            self._ranks[rootN1] += 1
        
        return True