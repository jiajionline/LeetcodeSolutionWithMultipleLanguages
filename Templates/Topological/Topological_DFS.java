// Topological_DFS, 三色法   O(E+V)
public class Topological {
    private List<List<Integer> graph;
    private int[] visited; // 0 unvisited, 1 visiting, 2 visited
    private boolean isValid;
    public boolean canFinish(int N, int[][] edges) {
        graph = new ArrayList<>();
        for(int i=0;i<N;i++) 
            graph.add(new ArrayList<Integer>());
        
        visited = new int[N];

        for(int[] edge : edges){
            int end = edge[0], start = edge[1];
            graph.get(start).add(end);
        }

        for(int i=0;i<N;i++) {
            if(visited[i] == 0) dfs(i);
        }

        return isValid;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for(int v : graph.get(u)) {
            if(visited[v] == 0) dfs(v);
            else if(visited[v] == 1) valid = false;
        }

        visited[u] = 2;
    }
}