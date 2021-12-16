public class Solution {
    public IList<int> FindMinHeightTrees(int n, int[][] edges) {
        var ans = new List<int>();
        if(n < 1) return ans;
        if(n == 1)
        {
            ans.Add(0);
            return ans;
        }
        var graph = BuildGraph(edges);
        var currMHT = int.MaxValue;
        
        for(var node = 0;node<n;node++)
        {
            var depth = Traverse(node, graph, currMHT);
            
            if(depth <= currMHT)
            {
                if(depth < currMHT)
                    ans.Clear();
                
                ans.Add(node);
                currMHT = depth;
            }
        }
        
        return ans;
    }
    
    private Dictionary<int, List<int>> BuildGraph(int[][] edges)
    {
        var graph = new Dictionary<int, List<int>>();
        foreach(var edge in edges)
        {
            if(!graph.ContainsKey(edge[0])) graph.Add(edge[0], new List<int>());
            if(!graph.ContainsKey(edge[1])) graph.Add(edge[1], new List<int>());
            graph[edge[0]].Add(edge[1]);
            graph[edge[1]].Add(edge[0]);
        }
        
        return graph;
    }
    
    private int Traverse(int root, Dictionary<int, List<int>> graph, int currMHT)
    {
        var queue = new Queue<int>();
        queue.Enqueue(root);
        var depth = 0;
        var visited = new HashSet<int>();
        visited.Add(root);
        
        while(queue.Count > 0)
        {
            depth++;
            if(depth > currMHT) return int.MaxValue;
            var c = queue.Count;
            while(c-- > 0)
            {
                var node = queue.Dequeue();
                foreach(var neighbor in graph[node])
                {
                    if(visited.Contains(neighbor)) continue;
                    visited.Add(neighbor);
                    queue.Enqueue(neighbor); 
                }
            }
        }
        
        return depth;
    }
}