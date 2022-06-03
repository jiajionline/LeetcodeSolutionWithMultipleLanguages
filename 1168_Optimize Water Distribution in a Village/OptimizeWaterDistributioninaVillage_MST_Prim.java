class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        //add a virtual village to connect with each village with wells[i] cost
        for(int i=1;i<=n;i++) graph.computeIfAbsent(0, value -> new HashMap<Integer, Integer>()).put(i, wells[i-1]);
        for(int[] pipe : pipes) {
            int u = pipe[0], v = pipe[1], cost = pipe[2];
            int costUtoV = graph.computeIfAbsent(u, value -> new HashMap<Integer, Integer>()).getOrDefault(v, Integer.MAX_VALUE);
            int costVtoU = graph.computeIfAbsent(v, value -> new HashMap<Integer, Integer>()).getOrDefault(u, Integer.MAX_VALUE);
            graph.get(u).put(v, Math.min(cost, costUtoV));
            graph.get(v).put(u, Math.min(cost, costVtoU));
        }
        
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        // MST Prim
        Set<Integer> visited = new HashSet<>();
        pq.offer(new int[]{0,0});
        while(pq.size() > 0) {
            int[] cur = pq.poll();
            int curNode = cur[0], distance = cur[1];
            if(!visited.add(curNode)) continue;
            ans += distance;
            for(int nei : graph.getOrDefault(curNode, new HashMap<Integer,Integer>()).keySet()) {
                if(!visited.contains(nei))
                    pq.offer(new int[]{nei, graph.get(curNode).get(nei)});
            }
        }
        
        return ans;
    }
}