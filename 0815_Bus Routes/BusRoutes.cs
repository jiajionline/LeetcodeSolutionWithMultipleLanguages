public class Solution {
    public int NumBusesToDestination(int[][] routes, int source, int target) {
        if(routes == null || routes.Length == 0) return -1;
        if(source == target) return 0;
        var graph = new Dictionary<int, List<int>>();
        for(int i=0;i<routes.Length;i++){
            var stops = routes[i];
            foreach(var s in stops){                
                if(!graph.ContainsKey(s))    
                    graph.Add(s, new List<int>());
                graph[s].Add(i);
            }
        }
        // key is stop, value is route
        var dict = new Dictionary<int, int>();
        // check if the route processed or not
        var visited = new HashSet<int>();
        
        var queue = new Queue<int>();

        queue.Enqueue(source);
        var buses = 0;
        
        while(queue.Count > 0)
        {
            buses++;
            var size = queue.Count;
            
            while(size-- > 0)
            {
                var currStop = queue.Dequeue();
                
                foreach(var route in graph[currStop])
                {
                    if(visited.Contains(route)) continue;
                    visited.Add(route);
                    foreach(var stop in routes[route]){
                        if(stop == target) return buses;  
                        queue.Enqueue(stop);
                    }
                }
            }
        }
        
        return -1;
        
    }
}