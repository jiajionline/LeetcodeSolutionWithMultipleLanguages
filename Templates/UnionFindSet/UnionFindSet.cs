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