class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < n; i++)
            if (dfs(i, visited, graph)) ans.add(i);
        return ans;
    }

    // visited WHITE(not visit) 0, GRAY (visiting) 1, BLACK (visited) 2;
    public boolean dfs(int node, int[] visited, int[][] graph) {
        if (visited[node] > 0) return visited[node] == 2;

        visited[node] = 1;
        for (int next: graph[node]) {
            if (!dfs(next, visited, graph))
                return false;
        }

        visited[node] = 2;
        return true;
    }
}