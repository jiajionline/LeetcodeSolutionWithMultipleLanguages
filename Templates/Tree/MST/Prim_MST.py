from collections import defaultdict
from heapq import *

n = 4
edges = [[0,1,1],[0,3,3],[0,2,6],[2,3,2],[1,2,4],[1,3,5]]
g = defaultdict(list)

for e in edges:
    g[e[0]].append((e[1],e[2]))
    g[e[1]].append((e[0],e[2]))

q = []
cost = 0
visited = set()
heappush(q, (0,0))
for _ in range(n):
    w, u = heappop(q)
    if u in visited: continue
    cost += w
    visited.add(u)
    for v, w in g[u]:
        if v in visited: continue
        heappush(q, (w, v))

print(cost)