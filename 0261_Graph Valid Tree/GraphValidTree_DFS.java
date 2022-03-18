class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList(n);
        for(int i=0;i<n;i++) graph.add(new ArrayList<Integer>());
        for(int i=0;i<edges.length;i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        Set<Integer> visited = new HashSet();
        visited.add(0);
        var ans = DFS(graph, 0, -1, visited);
        if(!ans) return false;
        return visited.size() == n ? true : false;
        
    }
    
    private boolean DFS(List<List<Integer>> graph, int node, int parent, Set<Integer> visited) {
        for(int next : graph.get(node)) {
            if(next == parent) continue;
            if(visited.contains(next)) return false;
            visited.add(next);
            if(!DFS(graph, next, node, visited)) return false;
        }
        
        return true;
    }
}