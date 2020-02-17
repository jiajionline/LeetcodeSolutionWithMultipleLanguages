class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      List<List<Integer>> adjList = new ArrayList<>();
      for(int i = 0; i < edges.length + 1; i++){
          adjList.add(new ArrayList<>());
      }
      for(int[] edge : edges){
        int v = edge[0];
        int u = edge[1];
        
        HashSet<Integer> visited = new HashSet<>();
        
        if(dfs(visited, u, v, adjList)){ // return true if there's a path between u and v already
          // connect u and v directly make it a graph from tree
          return edge;
        }
        // if the path doesnt exist 
        
        adjList.get(u).add(v);
        adjList.get(v).add(u);
      }
      return new int[]{};
    }
    private boolean dfs(HashSet<Integer> visited, int u, int v, List<List<Integer>> adjList){
      // base case , when u and v are the same node 
      if(u == v) return true;
      
      //mark u as visited
      visited.add(u);
      
      
      // check every neighbors
      for(int next : adjList.get(u)){
        if(visited.contains(next)) continue;
        if(dfs(visited, next, v, adjList)) return true;
      }
      return false;
    }
}