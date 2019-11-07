   public class Solution
    {
        public double[] CalcEquation(IList<IList<string>> equations, double[] values, IList<IList<string>> queries)
        {
            //build a directed graph
            var graph = new Dictionary<string, Dictionary<string, double>>();
            for(int i=0;i<equations.Count;i++)
            {
                var start = equations[i][0];
                var end = equations[i][1];
                var val = values[i];
                if (!graph.ContainsKey(start))
                {
                    graph.Add(start, new Dictionary<string, double>());
                }

                if (!graph.ContainsKey(end))
                {
                    graph.Add(end, new Dictionary<string, double>());
                }

                graph[start].Add(end, val);
                graph[end].Add(start, 1.0 / val);
            }

            var ans = new double[queries.Count];

            for (int i = 0; i < queries.Count; i++)
            {
                var start = queries[i][0];
                var end = queries[i][1];
                if (graph.ContainsKey(start) && graph.ContainsKey(end))
                {
                    ans[i] = DFS(start, end, graph, new HashSet<string>());
                }
                else
                {
                    ans[i] = -1.0;
                }   
            }

            return ans;
        }

        private double DFS(string start, string end, Dictionary<string, Dictionary<string, double>> graph, HashSet<string> visited)
        {
            if (start.Equals(end)) return 1.0;
            visited.Add(start);
            foreach(var n in graph[start].Keys)
            {
                if (visited.Contains(n)) continue;
                var val = DFS(n, end, graph, visited);
                if (val > 0) return val * graph[start][n];
            }

            return -1.0;
        }
    }