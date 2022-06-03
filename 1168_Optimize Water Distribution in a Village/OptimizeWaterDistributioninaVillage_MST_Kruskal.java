class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n+1);
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<wells.length;i++) {
            edges.add(new int[]{0, i+1, wells[i]});
        }
        for(int[] pipe : pipes) edges.add(pipe);
        Collections.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        int ans = 0;
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], distance = edge[2];
            if(uf.union(u, v)) ans += distance;
        }
        
        return ans;
    }
}

class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for(int i=0;i<parent.length;i++) parent[i] = i;
    }
    
    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if(pX == pY) return false;
        parent[pX] = pY;
        return true;
    }
}