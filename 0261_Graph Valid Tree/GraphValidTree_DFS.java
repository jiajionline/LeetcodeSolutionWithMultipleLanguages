class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length + 1 != n) return false;
        Map<Integer, List<Integer>> graph = build(edges, n);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        if(!DFS(graph, 0, -1, visited)) return false;
        return visited.size() == n;
    }
    
    private Map<Integer, List<Integer>> build(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++) 
            graph.putIfAbsent(i, new ArrayList<Integer>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
    
    private boolean DFS(Map<Integer, List<Integer>> graph, int node, int parent, Set<Integer> visited) {
        
        for(int next : graph.get(node)) {
            if(next == parent) continue;
            if(visited.contains(next)) return false;
            visited.add(next);
            if(!DFS(graph, next, node, visited)) return false;
        }
        
        return true;
    }
}