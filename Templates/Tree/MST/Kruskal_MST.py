from collections import defaultdict
from heapq import *

n = 4
edges = [[0,1,1],[0,3,3],[0,2,6],[2,3,2],[1,2,4],[1,3,5]]
parent = list(range(n))

def find(x):
    if(x != parent[x]):
        parent[x] = find(parent[x])
    return parent[x]

cost = 0
for u,v,w in sorted(edges, key=lambda x: x[2]):
    ru, rv = find(u), find(v)
    if ru == rv: continue
    parent[ru] = rv
    cost += w
    
print(cost)