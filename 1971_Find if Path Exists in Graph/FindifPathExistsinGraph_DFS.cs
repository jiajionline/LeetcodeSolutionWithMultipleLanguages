public class Solution {
    private bool seen = false;
    public bool ValidPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        
        var graph = new Dictionary<int, List<int>>();
        
        for (int i = 0; i < edges.Length; i++)
        {
            var pair = edges[i];

            if (!graph.ContainsKey(pair[0])) graph.Add(pair[0], new List<int>());
            if (!graph.ContainsKey(pair[1])) graph.Add(pair[1], new List<int>());

            graph[pair[0]].Add(pair[1]);
            graph[pair[1]].Add(pair[0]);
        }
        
        var visited = new HashSet<int>();
        DFS(graph, start, end, visited);
        return seen;
    }
    
    private void DFS(Dictionary<int, List<int>> graph, int start, int end, HashSet<int> visited)
    {
        if(seen) return;
        
        if(start == end)
        {
            seen = true;
            return;
        }
        
        if(visited.Contains(start)) return;
        visited.Add(start);
        foreach(var next in graph[start])
        {
            DFS(graph, next, end, visited);
        }
    }
}