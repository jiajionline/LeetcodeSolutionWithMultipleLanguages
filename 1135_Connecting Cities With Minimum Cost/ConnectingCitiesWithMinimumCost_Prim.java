class Solution {
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] connection : connections) {
            int u = connection[0], v = connection[1], w = connection[2];
            graph.computeIfAbsent(u, (k) -> new ArrayList<int[]>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, (k) -> new ArrayList<int[]>()).add(new int[]{u, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> Integer.compare(a[1], b[1])); // MST Prim
        pq.offer(new int[]{1,0});
        
        Set<Integer> visited = new HashSet<Integer>();
        int cost = 0;
        while(pq.size() > 0) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];
            if(visited.contains(u)) continue;
            cost += w;
            visited.add(u);
            if(graph.containsKey(u)) {
                for(int[] nei : graph.get(u)) {
                    if(visited.contains(nei[0])) continue;
                    pq.offer(new int[]{nei[0], nei[1]});
                }
            }
        }
        
        return visited.size() == n ? cost : -1;
    }
}