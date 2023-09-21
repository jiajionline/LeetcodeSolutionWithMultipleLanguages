class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Map<Integer,Set<Integer>> graph = build(edges);
        return traverse(graph, source, destination, new HashSet<Integer>());
    }

    private boolean traverse(Map<Integer, Set<Integer>> graph, int source, int desc, Set<Integer> visited) {
        if(visited.contains(source) || !graph.containsKey(source)) return false;
        if(source == desc) return true;
        visited.add(source);
        for(int next : graph.get(source)) {
            if(traverse(graph, next, desc, visited)) return true;
        }
        return false;

    }

    private Map<Integer, Set<Integer>> build(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int vertexA =edge[0], vertexB = edge[1];
            graph.putIfAbsent(vertexA, new HashSet<Integer>());
            graph.putIfAbsent(vertexB, new HashSet<Integer>());
            graph.get(vertexA).add(vertexB);
            graph.get(vertexB).add(vertexA);
        }
        return graph;
    }
}