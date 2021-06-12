public class Solution {
    private const int VISITING = 1;
    private const int VISITED = 2;
    
    public int[] FindOrder(int numCourses, int[][] prerequisites) {
        var graph = new List<List<int>>(numCourses);
        var visited = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            graph.Add(new List<int>());
        }
        
        foreach(var item in prerequisites){
            var course = item[0];
            var preCourse = item[1];
            graph[preCourse].Add(course);
        }
        
        var stack = new Stack<int>(numCourses);
        for(int course = 0; course < numCourses; course++)
            if(DFS(graph, course, visited, stack)) return new int[0];
        
        int[] ans = new int[numCourses];
    
        for(int i=0;i< numCourses;i++){
            ans[i] = stack.Pop();
        }
        
        return ans;
    }
    
    private bool DFS(List<List<int>> graph, int v, int[] visited, Stack<int> stack){
        if(visited[v] == VISITED) return false;
        if(visited[v] == VISITING) return true;
        visited[v] = VISITING;
        foreach(var i in graph[v]){
            if(DFS(graph, i, visited, stack)) return true;
        }
        
        visited[v] = VISITED;
        stack.Push(v);
        return false;
    }
    
}