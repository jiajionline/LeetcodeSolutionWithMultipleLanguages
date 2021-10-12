public class Solution
    {
        public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int k)
        {
            var graph = new Dictionary<int, List<Tuple<int, int>>>();
            for (int i = 0; i < flights.Length; i++)
            {
                if (!graph.ContainsKey(flights[i][0])) graph.Add(flights[i][0], new List<Tuple<int, int>>());
                graph[flights[i][0]].Add(Tuple.Create(flights[i][1], flights[i][2]));
            }

            int ans = int.MaxValue;
            var queue = new Queue<Tuple<int, int>>();
            queue.Enqueue(Tuple.Create(src, 0));
            int steps = 0;

            while (queue.Count > 0)
            {
                var size = queue.Count;
                while (size-- > 0)
                {
                    var item = queue.Dequeue();
                    var curr = item.Item1;
                    var cost = item.Item2;
                    if (curr == dst)
                        ans = Math.Min(ans, cost);

                    if (!graph.ContainsKey(curr)) continue;

                    foreach (var dirs in graph[curr])
                    {
                        if (dirs.Item2 + cost > ans) continue;
                        queue.Enqueue(Tuple.Create(dirs.Item1, dirs.Item2 + cost));
                    }
                }

                if (steps++ > k) break;
            }
            return ans == int.MaxValue ? -1 : ans;
        }
    }