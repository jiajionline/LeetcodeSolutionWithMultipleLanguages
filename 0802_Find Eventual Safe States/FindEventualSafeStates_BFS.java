class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] safe = new boolean[n];
        List<Set<Integer>> adjGraph = new ArrayList<>();
        List<Set<Integer>> rGraph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjGraph.add(new HashSet<Integer>());
            rGraph.add(new HashSet<Integer>());
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            // found a terminal node 
            if(graph[i].length == 0) q.offer(i);
            for(int j : graph[i]){
                adjGraph.get(i).add(j);
                rGraph.get(j).add(i);
            }
        }
        
        while(q.size() > 0){
            int node = q.poll();
            safe[node] = true;
            for(int i : rGraph.get(node)){
                adjGraph.get(i).remove(node);
                // can be guided to a terminal node
                if(adjGraph.get(i).isEmpty()) q.offer(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) 
            if(safe[i]) ans.add(i);
        
        return ans;
    }
}