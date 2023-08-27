class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 0) return ans;
        if(n == 1) {
            ans.add(0);
            return ans;
        }
        
        int minHeight = n;
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        
        //get all leaves
        List<Integer> leaves = new ArrayList<Integer>();
        for(int node = 0; node<n; node++)
        {
            if(graph.get(node).size() == 1) leaves.add(node);
        }
        
        //trim all leaves until the loop reaches the centroids
        var remaining = n;
        while(remaining > 2)
        {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int leaf : leaves)
            {
                int next = graph.get(leaf).get(0);
                graph.get(next).remove(Integer.valueOf(leaf));
                if(graph.get(next).size() == 1) newLeaves.add(next);
            }
            
            leaves = newLeaves;
        }
        
        return leaves;

    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int p1 = edge[0], p2 = edge[1];
            graph.putIfAbsent(p1, new ArrayList<Integer>());
            graph.putIfAbsent(p2, new ArrayList<Integer>());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        return graph;
    }

    private int height(Map<Integer, List<Integer>> graph, int node) {
        if(!graph.containsKey(node)) return Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int height = 0;
        Set<Integer> visited = new HashSet<>();
        
        while(q.size() > 0) {
            int size = q.size();
            height++;
            while(size-- > 0) {
                int currNode = q.poll();
                visited.add(currNode);
                for(int nextNode : graph.get(currNode)){
                    if(visited.contains(nextNode)) continue;
                    q.offer(nextNode);
                }
            }
        }

        return height;
    }
}