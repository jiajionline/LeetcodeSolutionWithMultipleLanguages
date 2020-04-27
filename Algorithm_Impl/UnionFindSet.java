public class UnionFindSet{
    private int[] parents;
    private int[] ranks;

    public UnionFindSet(int count){
        parents = new int[count+1];
        ranks = new int[count+1];

        for(int i=0;i<parents.length;i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    //return the root node
    public int find(int n){
        if(n != parents[n]){
            parents[n] = find(parents[n]);
        }

        return parents[n];
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
            ranks[rootN1] += 1;
        }
   
        return true;
    }
}