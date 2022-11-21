class Solution {
    // Adjacency list
    Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();

    private void BFS(int[] dist, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        // Time for starting node is 0
        dist[k] = 0;
        
        while (!q.isEmpty()) {
            int currNode = q.remove();
            // Broadcast the signal to graphacent nodes
            for (Pair<Integer, Integer> edge : graph.getOrDefault(currNode, new ArrayList<Pair<Integer,Integer>>())) {
                int time = edge.getKey();
                int next = edge.getValue();
                
                // Fastest signal time for next so far
                // dist[currNode] + time : 
                // time when signal reaches next
                int arrivalTime = dist[currNode] + time;
                if (dist[next] > arrivalTime) {
                    dist[next] = arrivalTime;
                    q.add(next);
                }
            }
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the graphacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(source).add(new Pair(travelTime, dest));
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        BFS(dist, k);
        
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        
        // INT_MAX signifies atleat one node is unreachable
        return ans == Integer.MAX_VALUE ? -1 : answer;
    }
}