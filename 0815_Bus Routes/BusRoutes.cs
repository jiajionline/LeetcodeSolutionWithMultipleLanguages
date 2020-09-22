public class Solution {
    public int NumBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;
        //build a graph
        var dict = new Dictionary<int, List<int>>();
        for(int i=0;i<routes.Length;i++){
            foreach(var stop in routes[i]){
                if(!dict.ContainsKey(stop)) dict.Add(stop, new List<int>());
                dict[stop].Add(i);
            }
        }

        var visited = new bool[501];
        var queue = new Queue<int>();
        queue.Enqueue(S);
        int buses = 0;
        int count = queue.Count;
        while(queue.Count > 0){
            int size = queue.Count;
            buses++;
            while(size-- > 0){
                var current = queue.Dequeue();                
                foreach(var bus in dict[current]){
                    if(visited[bus]) continue;
                    visited[bus] = true;
                    foreach(var stop in routes[bus]){
                        if(stop == T) return buses;
                        queue.Enqueue(stop);
                    }
                }
            }
        }

        return -1;
    }
}