class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Boolean> status = new HashMap<>();
        for(int i=0;i<graph.length;i++) {
            if(isSafe(graph, i, status)) ans.add(i);
        }
        
        return ans;
    }
    
    private boolean isSafe(int[][] graph, int node, Map<Integer, Boolean> status) {
        if(status.containsKey(node)) return status.get(node);
        status.put(node, false);
        
        for(int next : graph[node]) {
            if(!isSafe(graph, next, status)){
                return false;
            }
        }
        
        status.put(node, true);
        return true;
    }
}