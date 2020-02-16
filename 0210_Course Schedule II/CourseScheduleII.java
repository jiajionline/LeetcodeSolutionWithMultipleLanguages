class Solution {
    
    private final int VISITED = 1;
    private final int VISITING = 2;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        List<Integer> result = new LinkedList<Integer>();
        
        //initialize a graph
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        //build a graph
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            graph.get(preCourse).add(course);
        }
        
        for(int i=0;i<numCourses;i++){
            if(DFS(graph, visited, i, result)) return new int[0];
        }
        
        return result.stream().mapToInt(i->i).toArray();
     
    }
    
    //return true if there is a cycle.
    private boolean DFS(List<List<Integer>> graph, int[] visited, int curr, List<Integer> result){
        if(visited[curr] == VISITED) return false;
        if(visited[curr] == VISITING) return true;
        visited[curr] = VISITING;
        
        for(int next : graph.get(curr)){
            if(DFS(graph, visited, next,result)) return true;
        }
        
        result.add(0,curr);
        visited[curr] = VISITED;
        return false;
    }
}