public class Solution {
    public int[] FindRedundantConnection(int[][] edges) {
        var adjacencyList = new List<List<int>>();
        
        for(int i=0;i<edges.Length+1;i++)
        {
            adjacencyList.Add(new List<int>());
        }
        
        for(int i=0;i<edges.Length;i++)
        {
            var u = edges[i][0];
            var v = edges[i][1];
            
            if(DFS(adjacencyList, u, v, new HashSet<int>())) return edges[i];
            
            adjacencyList[u].Add(v);
            adjacencyList[v].Add(u);
        }
        
        return new int[]{};
    }
    
    private bool DFS(List<List<int>> adjacencyList, int u, int v, HashSet<int> visited)
    {
        if(u == v) return true;
        visited.Add(u);
        
        foreach(var next in adjacencyList[u])
        {
            if(visited.Contains(next)) continue;
            if(DFS(adjacencyList, next, v, visited)) return true;
        }
        
        return false;
    }
}