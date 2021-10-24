public class Solution {
    public int FindCircleNum(int[][] isConnected) {
        var unionFindSet = new UnionFindSet(isConnected.Length);
        for(int i=0;i<isConnected.Length;i++)
        {
            for(int j=i+1;j<isConnected[i].Length;j++)
            {
                if(isConnected[i][j] == 1){
                    unionFindSet.Union(i,j);
                }
            }
        }
        
        var set = new HashSet<int>();
        for(int i=0;i<isConnected.Length;i++)
            set.Add(unionFindSet.Find(i));
        
        return set.Count;
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
            parents[i] = i;
        
        for(int i=0;i<ranks.Length;i++)
            ranks[i] = 1;
    }
    
    public int Find(int n)
    {
        if(n != parents[n])
            parents[n] = Find(parents[n]);
        
        return parents[n];
    }
    
    public bool Union(int u, int v)
    {
        var rootU = Find(u);
        var rootV = Find(v);
        
        if(rootU == rootV) return false;
        
        if(ranks[rootU] > ranks[rootV])
            parents[rootV] = rootU;
        else if(ranks[rootU] < ranks[rootV])
            parents[rootU] = rootV;
        else{
            parents[rootU] = rootV;
            ranks[rootV]++;
        }
            
        return true;
    }
}