class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); ++i) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(start, new HashMap<String, Double>());
            graph.get(start).put(end, val);
            graph.putIfAbsent(end, new HashMap<String, Double>());
            graph.get(end).put(start, 1.0/ val);
        }
        
        double[] ans = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); ++i) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
            } else {
                ans[i] = DFS(start, end, new HashSet<String>(), graph);
            }
        }
        
        return ans;
    }
    
    private double DFS(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (start.equals(end)) return 1.0;
        visited.add(start);
        if(!graph.containsKey(start)) return -1.0;
        
        for(String next : graph.get(start).keySet()) {
            if(visited.contains(next)) continue;
            double val = DFS(next, end, visited, graph);
            if(val > 0) {
                double curr = graph.get(start).get(next);
                return val * curr;
            }
        }
        
        return -1.0;
    }
}