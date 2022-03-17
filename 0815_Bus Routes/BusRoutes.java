class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(routes == null || routes.length == 0) return 0;
        if(S == T) return 0;
        // build a graph, key is stop, value is the list of routes for the stop
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int route = 0; route < routes.length; route++) {
            for(int stop : routes[route]) {
                graph.putIfAbsent(stop, new ArrayList<Integer>());
                graph.get(stop).add(route);
            }
        }
        
        int ans = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(S);
        Set<Integer> visited = new HashSet();
        
        while(q.size() > 0) {
            int count = q.size();
            ans++;
            
            while(count-- > 0) {
                int currStop = q.poll();
                for(Integer route : graph.get(currStop)) {
                    if(visited.contains(route)) continue;
                    visited.add(route);
                    for(int nextStop : routes[route]) {
                        if(nextStop == T) return ans;
                        q.add(nextStop);
                    }
                }
            }
        }
        
        return -1;
    }
}