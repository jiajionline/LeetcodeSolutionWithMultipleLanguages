public class Solution {
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
        visited.Add(start);
        
        var queue = new Queue<int>();
        queue.Enqueue(start);
        
        while(queue.Count > 0)
        {
            var vertex = queue.Dequeue();
            if(vertex == end) return true;
            foreach(var next in graph[vertex])
            {
                if(visited.Contains(next)) continue;
                visited.Add(next);
                queue.Enqueue(next);
            }
        }
        
        return false;
    }
}