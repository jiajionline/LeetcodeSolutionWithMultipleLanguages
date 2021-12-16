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
        
        //get all leaves
        var leaves = new List<int>();
        for(int node = 0;node<n;node++)
        {
            if(graph[node].Count == 1) leaves.Add(node);
        }
        
        //trim all leaves until the loop reaches the centroids
        var remaining = n;
        while(remaining > 2)
        {
            remaining -= leaves.Count;
            var newLeaves = new List<int>();
            
            foreach(var leaf in leaves)
            {
                var next = graph[leaf][0];
                graph[next].Remove(leaf);
                if(graph[next].Count == 1) newLeaves.Add(next);
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
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
}