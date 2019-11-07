import collections

class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """        
        def traverse(start, end, visited):
            if start == end: return 1.0
            visited.add(start)
            for n in graph[start]:
                if n in visited: continue
                #DFS
                v = traverse(n, end, visited)
                # v > 0 means an adjacent node has been found
                if v > 0: return v * graph[start][n]
            # can't find any adjacent node, return -1.0
            return -1.0

        #build a graph
        graph = collections.defaultdict(dict)
        for (x,y), val in zip(equations, values):
            graph[x][y] = val
            graph[y][x] = 1.0/val
        
        #iterate queries
        ans = [traverse(start, end, set()) if start in graph and end in graph else -1.0 for start, end in queries]
        return ans