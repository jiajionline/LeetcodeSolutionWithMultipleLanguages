public class Solution
{
    public double FrogPosition(int n, int[][] edges, int t, int target)
    {
        var p = new double[n + 1];
        p[1] = 1.0;

        List<List<int>> graph = BuildGraph(n, edges);

        var visited = new bool[n + 1];
        visited[1] = true;

        var queue = new Queue<int>();
        queue.Enqueue(1);

        while (t-- > 0)
        {
            var count = queue.Count;
            while (count-- > 0)
            {
                var node = queue.Dequeue();

                var childrenCount = 0;
                foreach (var next in graph[node])
                {
                    if (!visited[next]) childrenCount++;
                }

                foreach (var next in graph[node])
                {
                    if (!visited[next])
                    {
                        queue.Enqueue(next);
                        visited[next] = true;
                        p[next] = p[node] / childrenCount;
                    }
                }

                // if the node has children, sould set 0 since it's impossible to have prob when reaching out T
                if (childrenCount > 0) p[node] = 0;
            }
        }

        return p[target];
    }

    private static List<List<int>> BuildGraph(int n, int[][] edges)
    {
        var graph = new List<List<int>>();
        for (int i = 0; i <= n; i++)
            graph.Add(new List<int>());

        for (int i = 0; i < edges.Length; i++)
        {
            var edge = edges[i];
            graph[edge[0]].Add(edge[1]);
            graph[edge[1]].Add(edge[0]);
        }

        return graph;
    }
}