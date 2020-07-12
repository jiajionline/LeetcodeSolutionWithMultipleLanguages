public class Solution {
    public IList<string> FindItinerary(IList<IList<string>> tickets) {
        Dictionary<string, List<string>> graph = new Dictionary<string, List<string>>();
        foreach(var edge in tickets){
            if(!graph.ContainsKey(edge[0])){
                graph.Add(edge[0], new List<string>());
            }

            graph[edge[0]].Add(edge[1]);
        }

        foreach(var entry in graph){
            entry.Value.Sort();
        }

        var ans = new List<string>();
        Visit(graph, "JFK", ans);
        ans.Reverse();
        return ans;
    }

    private void Visit(Dictionary<string, List<string>> graph,string departure, IList<string> ans){
        
        if(graph.ContainsKey(departure)){
            var arrivals = graph[departure];
            while(arrivals!=null && arrivals.Count > 0){
                var arrival = arrivals.FirstOrDefault();
                arrivals.RemoveAt(0);
                Visit(graph, arrival, ans);
            }    
        }
        
        ans.Add(departure);
    }
}