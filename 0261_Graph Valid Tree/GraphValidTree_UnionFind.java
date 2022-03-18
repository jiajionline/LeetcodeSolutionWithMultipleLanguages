class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            if (!unionFind.union(nodeA, nodeB)) {
                return false;
            }
        }
        
        return true;
    }
}

class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
        }
    }
    
    public int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    public boolean union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        if (rootA == rootB) {
            return false;
        }
        parent[rootA] = rootB;
        return true;
    } 
}