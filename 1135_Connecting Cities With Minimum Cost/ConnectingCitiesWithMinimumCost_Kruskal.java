class Solution {
    private int[] parent;
    public int minimumCost(int n, int[][] connections) {
        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;
        
        int cost = 0;
        Arrays.sort(connections, (a,b) -> Integer.compare(a[2], b[2]));
        for(int[] conn : connections) {
            int u = conn[0], v = conn[1], w = conn[2];
            int ru = find(u), rv = find(v);
            if(ru == rv) continue;
            cost += w;
            parent[ru] = rv;
            n--;
        }
        
        
        return n == 1 ? cost : -1;
    }
    
    private int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
}