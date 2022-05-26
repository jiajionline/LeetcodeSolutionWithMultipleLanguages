public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFindSet uf = new UnionFindSet(n);
        for(int i=0;i<n;i++) {
            int[] connected = isConnected[i];
            for(int j=0;j<connected.length;j++) {
                if(connected[j] == 1) uf.union(i,j);
            }
        }
        
        int count = 0;
        for(int i=0;i<n;i++)
            if(uf.find(i) == i) count++;
        
        return count;
    }
}

 class UnionFindSet{
    private int[] parents;
    private int[] ranks;

    public UnionFindSet(int count){
        parents = new int[count];
        ranks = new int[count];

        for(int i=0;i<parents.length;i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    //return the root node
    public int find(int n){
        if(n != parents[n])
            return find(parents[n]);
        return n;
    }

    public boolean union(int n1, int n2) {
        int rootN1 = find(n1);
        int rootN2 = find(n2);
        if (rootN1 == rootN2) return false;
   
        if (ranks[rootN1] > ranks[rootN2])
            parents[rootN2] = rootN1;           
        else if (ranks[rootN2] > ranks[rootN1])
            parents[rootN1] = rootN2;
        else {
            parents[rootN1] = rootN2;
            ranks[rootN2] += 1;
        }
   
        return true;
    }
}