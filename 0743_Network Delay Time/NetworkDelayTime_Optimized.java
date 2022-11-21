class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap();
        
        //build a graph , key is the node, value is (connected node , weight)
        for (int[] edge: times) {
            graph.putIfAbsent(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // (the weight from k, Node)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        Map<Integer, Integer> dist = new HashMap();

        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int delayTime = item[0], node = item[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, delayTime);
            for (int[] edge: graph.getOrDefault(node, new ArrayList<int[]>())) {
                int next = edge[0], addedDelayTime = edge[1];
                if (!dist.containsKey(next))
                    pq.offer(new int[]{delayTime+addedDelayTime, next});
            }
        }

        if (dist.size() != n) return -1;
        int ans = 0;
        for (int delayTime: dist.values())
            ans = Math.max(ans, delayTime);
        return ans;
    }
}