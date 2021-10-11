class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        
        //build a graph , key is the node, value is (connected node , weight)
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // (the weight from K, Node)
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int delayTime = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, delayTime);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int neighbor = edge[0], addedDelayTime = edge[1];
                    if (!dist.containsKey(neighbor))
                        heap.offer(new int[]{delayTime+addedDelayTime, neighbor});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int delayTime: dist.values())
            ans = Math.max(ans, delayTime);
        return ans;
    }
}