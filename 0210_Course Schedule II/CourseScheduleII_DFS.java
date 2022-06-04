class Solution {
    private List<List<Integer>> graph;
    private int[] visited;
    private boolean isValid = true;
    private int[] ans;
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        ans = new int[numCourses];
        index = numCourses-1;
        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[1], v = prerequisite[0];
            graph.get(u).add(v);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numCourses; i++) {
            if(visited[i] == 0) dfs(i);
        }
        
        return isValid ? ans : new int[0];
    }
    
    private void dfs(int u) {
        visited[u] = 1;
        for(int v : graph.get(u)) {
            if(visited[v] == 0) dfs(v);
            else if(visited[v] == 1) isValid = false;
        }
        
        ans[index--] = u;
        visited[u] = 2;
    }
}