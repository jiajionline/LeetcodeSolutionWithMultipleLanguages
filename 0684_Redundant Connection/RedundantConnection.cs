public class Solution {
    public int[] FindRedundantConnection(int[][] edges) {
        var unionFindSet = new UnionFindSet(edges.Length);
        foreach(var edge in edges)
        {
            if(!unionFindSet.Union(edge[0], edge[1])) return edge;
        }
        
        return new int[]{-1,-1};
    }
}

public class UnionFindSet
{
    private int[] parents;
    private int[] ranks;
    
    public UnionFindSet(int n)
    {
        parents = new int[n+1];
        ranks = new int[n+1];
        
        for(int i=0;i<parents.Length;i++)
        {
            parents[i] = i;
        }
        
        for(int i=0;i<ranks.Length;i++)
        {
            ranks[i] = 1;
        }
    }
    
    public int Find(int n)
    {
        if(n != parents[n])
            parents[n] = Find(parents[n]);
        return parents[n];
    }
    
    public bool Union(int n1, int n2)
    {
        var rootN1 = Find(n1);
        var rootN2 = Find(n2);
        
        if(rootN1 == rootN2) return false;
        if(ranks[rootN1] > ranks[rootN2]){
            parents[rootN2] = rootN1;
        }else if(ranks[rootN1] < ranks[rootN2]){
            parents[rootN1] = rootN2;
        }else{
            parents[rootN2] = rootN1;
            ranks[rootN1]++;
        }
        
        return true;
    }
}