class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFindSet uf = new UnionFindSet(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        int count = 0;
        for(int i=0;i<n;i++) {
            if(i == uf.find(i)) count++;
        }
        
        return count;
    }
}

class UnionFindSet {
    private int[] parent;
    private int[] rank;
    
    public UnionFindSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return false;
        
        if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;    
        }else if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        }else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
}