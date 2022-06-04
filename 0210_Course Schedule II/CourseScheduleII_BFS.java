class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[1], v = prerequisite[0];
            graph.computeIfAbsent(u, x-> new ArrayList<Integer>()).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        
        int count = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            ans[count++] = u;
            for(int v : graph.getOrDefault(u, new ArrayList<Integer>())) {
                if(--indegree[v] == 0) q.offer(v);
            }
        }
        
        return count == numCourses ? ans : new int[0];
    }
}