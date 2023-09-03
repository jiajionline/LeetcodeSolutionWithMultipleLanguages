class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFindSet uf = new UnionFindSet(26);
        for(String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '='){
                uf.union(equation.charAt(0)-'a', equation.charAt(3)-'a');
            }
        }

        for(String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '!'){
                if(uf.find(equation.charAt(0)-'a') == uf.find(equation.charAt(3)-'a')) return false;
            }
        }

        return true;
    }
}


public class UnionFindSet{
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
        if(n != parents[n]){
            parents[n] =  find(parents[n]);
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
            ranks[rootN2] += 1;
        }
   
        return true;
    }
}