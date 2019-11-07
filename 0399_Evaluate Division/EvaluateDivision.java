import java.util.*;

class Solution {
    Map<String, HashMap<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {        
        for (int i = 0; i < equations.size(); ++i) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double val = values[i];
            graph.computeIfAbsent(start, l -> new HashMap<String, Double>()).put(end, val);
            graph.computeIfAbsent(end, l -> new HashMap<String, Double>()).put(start, 1.0 / val);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); ++i) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
            } else {
                ans[i] = DFS(start, end, new HashSet<String>());
            }
        }

        return ans;
    }

    private double DFS(String start, String end, Set<String> visited) {
        if (start.equals(end))
            return 1.0;
        visited.add(start);
        if (!graph.containsKey(start))
            return -1.0;
        for (String n : graph.get(start).keySet()) {
            if (visited.contains(n))
                continue;
            double val = DFS(n, end, visited);
            if (val > 0)
                return val * graph.get(start).get(n);
        }
        return -1.0;
    }
}