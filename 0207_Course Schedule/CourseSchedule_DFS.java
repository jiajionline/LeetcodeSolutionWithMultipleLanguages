class Solution {
    private List<List<Integer>> graph;
    private int[] visited;
    private boolean isValid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[1], v = prerequisite[0];
            graph.get(u).add(v);
        }
        
        for(int i=0;i<numCourses; i++) {
            if(visited[i] == 0) dfs(i);
        }
        
        return isValid;
    }
    
    private void dfs(int u) {
        visited[u] = 1;
        for(int v : graph.get(u)) {
            if(visited[v] == 0) dfs(v);
            else if(visited[v] == 1) isValid = false;
        }
        visited[u] = 2;
    }
}