class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Map<Integer, Set<Integer>> graph = build(n, connections);
        
        for(List<Integer> connection : connections) {
            int nodeA = connection.get(0);
            int nodeB = connection.get(1);
            graph.get(nodeA).remove(nodeB);
            graph.get(nodeB).remove(nodeA);
            
            Set<Integer> visited = new HashSet<>();
            
            DFS(graph, 0, visited);
            
            if(visited.size() < n) {
                ans.add(connection);
            }
            
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }
        
        return ans;
        
    }
    
    private void DFS(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited) {
        if(visited.contains(node)) return;
        visited.add(node);
        for(int next : graph.get(node)) {
            DFS(graph, next, visited);
        }
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