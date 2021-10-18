public class Solution {
    public int ShortestPathLength(int[][] graph) {
        var n = graph.Length;
        var finalAns = (1 << n) - 1;
        
        var queue = new Queue<Tuple<int,int>>();
        var visited = new bool[n, (1<<n) ];
        
        for(int i=0;i<n;i++)
            queue.Enqueue(Tuple.Create(i,1 << i));
        
        int steps = 0;
        
        while(queue.Count > 0)
        {
            int s = queue.Count;
            
            while(s-- > 0)
            {
                var p = queue.Dequeue();
                var node = p.Item1;
                var state = p.Item2;

                if(state == finalAns) return steps;
                if(visited[node,state]) continue;
                visited[node,state] = true;
                foreach(int neighbor in graph[node])
                    queue.Enqueue(Tuple.Create(neighbor, state | 1 << neighbor));    
            }
            
            steps++;
        }
        
        return -1;
    }
}