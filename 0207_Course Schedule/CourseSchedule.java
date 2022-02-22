class Solution {

    private final static int VISITED = 1;
    private final static int VISITING = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            graph.get(preCourse).add(course);
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(hasCycle(i, graph, visited)) return false;
        }

        return true;
    }

    //return true if found cycle
    private boolean hasCycle(int curr, List<List<Integer>> graph, int[] visited){
        if(visited[curr] == VISITED) return false;
        if(visited[curr] == VISITING) return true;

        visited[curr] = VISITING;

        for(int next : graph.get(curr)){
            if(hasCycle(next, graph, visited)) return true;
        }

        visited[curr] = VISITED;
        return false;
    }
}