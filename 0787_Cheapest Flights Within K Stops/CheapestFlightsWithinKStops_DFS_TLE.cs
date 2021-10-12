public class Solution
    {
        private int ans = int.MaxValue;
        public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int k)
        {
            var graph = new Dictionary<int, List<Tuple<int, int>>>();
            for (int i = 0; i < flights.Length; i++)
            {
                if (!graph.ContainsKey(flights[i][0])) graph.Add(flights[i][0], new List<Tuple<int, int>>());
                graph[flights[i][0]].Add(Tuple.Create(flights[i][1], flights[i][2]));
            }

            var visited = new bool[n];
            visited[src] = true;
           // var ans = int.MaxValue;
            DFS(graph, src, dst, k+1, 0, visited);
            return ans == int.MaxValue ? -1 : ans;
        }

        private void DFS(Dictionary<int, List<Tuple<int, int>>> graph, int src, int dst, int k, int cost, bool[] visited)
        {
            if (src == dst)
            {
                ans = cost;
                return;
            }

            if (k == 0) return;
            
            if(!graph.ContainsKey(src)) return;
            
            foreach (var flights in graph[src])
            {
                if (visited[flights.Item1]) continue;
                // pruning, vital step!
                if (cost + flights.Item2 > ans) continue;
                visited[flights.Item1] = true;
                DFS(graph, flights.Item1, dst, k - 1, cost + flights.Item2, visited);
                visited[flights.Item1] = false;
            }

        }
    }