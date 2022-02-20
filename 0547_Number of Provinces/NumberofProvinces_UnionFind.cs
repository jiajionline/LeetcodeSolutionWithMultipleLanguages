public class Solution {
    public int FindCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.Length == 0) return 0;
        var n = isConnected.Length;
        var unionFind = new UnionFindSet(n);
        
        for(int u=0; u<n; u++) {
            for(int v=0; v<isConnected[u].Length; v++) {
                if(isConnected[u][v] == 1)
                    unionFind.Union(u,v);
            }
        }
        
        var set = new HashSet<int>();
        for(int u=0;u<n;u++)
            set.Add(unionFind.Find(u));
        
        return set.Count;
    }
}

public class UnionFindSet {
    private int[] parent;
    private int[] rank;
    
    public UnionFindSet(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int u=0; u<n; u++)
        {
            parent[u] = u;
            rank[u] = 1;
        }
    }
    
    public int Find(int u) {
        if(u != parent[u])
            return Find(parent[u]);
        return u;
    }
    
    public bool Union(int u, int v) {
        var rootU = Find(u);
        var rootV = Find(v);
        
        if(rootU == rootV) return false;
        
        if(rank[rootU] > rank[rootV])
            parent[rootV] = rootU;
        else if(rank[rootU] < rank[rootV])
            parent[rootU] = rootV;
        else{
            parent[rootU] = rootV;
            rank[rootV]++;
        }
            
        return true;
    }
}