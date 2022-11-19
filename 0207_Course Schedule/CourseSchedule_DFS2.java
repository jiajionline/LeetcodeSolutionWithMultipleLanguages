class Solution {
    private List<List<Integer>> graph;
    private int[] visited;
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
            if(visited[i] == 0){
                 if(!dfs(i)) return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int u) {
        visited[u] = 1;
        for(int v : graph.get(u)) {
            if(visited[v] == 0){
                boolean valid = dfs(v);
                if(!valid) return false;
            }
            else if(visited[v] == 1) return false;
        }
        visited[u] = 2;
        return true;
    }
}