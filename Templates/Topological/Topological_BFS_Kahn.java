// Topological_BFS_Kahn.java,   O(E+V)
public class Topological {
    public boolean canFinish(int N, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[N];
        for(int[] edge : edges){
            int end = edge[0], start = edge[1];
            graph.computeIfAbsent(start, x -> new ArrayList<Integer>()).add(end);
            indegree[end]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < N; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for(int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                if(--indegree[nei] == 0) q.offer(nei);
            }
        }

        return count == N;
    }
}