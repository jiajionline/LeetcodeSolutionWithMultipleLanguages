class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<Integer>());
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(DFS(graph, u, v, new HashSet<Integer>())) return edge;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return new int[2];
    }
    
    private boolean DFS(List<List<Integer>> graph, int u, int v, Set<Integer> visited) {
        if(u == v) return true;
        visited.add(u);
        for(Integer next : graph.get(u)) {
            if(visited.contains(next)) continue;
            if(DFS(graph, next, v, visited)) return true;
        }
        
        return false;
    }
}