class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Map<Integer, Set<Integer>> graph = build(n, connections);
        int[] steps = new int[n];
        Arrays.fill(steps, -1);
        DFS(graph, 0, -1, 0, steps, ans);
        return ans;
        
    }
    
    private int DFS(Map<Integer, Set<Integer>> graph, int node, int parent, int step, int[] steps, List<List<Integer>> ans) {
        steps[node] = step + 1;
        
        for(int next : graph.get(node)) {
            if(next == parent) continue;
            else if(steps[next] == -1) {
                steps[node] = Math.min(steps[node], DFS(graph, next, node, step+1, steps, ans));
            }else {
                steps[node] = Math.min(steps[node], steps[next]);
            }
        }
        
        if(steps[node] == (step + 1) && node != 0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(parent);
            res.add(node);
            ans.add(res);
        }
        
        return steps[node];
    }
    
    private Map<Integer, Set<Integer>> build(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++) graph.put(i, new HashSet<Integer>());
        
        for(List<Integer> list : connections) {
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));
        }
        
        return graph;
    }
}