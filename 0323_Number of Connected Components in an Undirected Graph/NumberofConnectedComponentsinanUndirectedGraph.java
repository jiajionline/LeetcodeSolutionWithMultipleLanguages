class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int components = n;
        for (int[] e : edges) {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);
            if (p1 != p2) {
                if (rank[p1] < rank[p2]) {
                    rank[p2] += rank[p1];
                    parent[p1] = p2;
                } else {
                    rank[p1] += rank[p2];
                    parent[p2] = p1;
                }
                components--;
            }
        }
        return components;
    }
    private int findParent(int[] parent, int i) {
        if (i == parent[i]) return i;
        // Path compression
        return parent[i] = findParent(parent, parent[i]); 
    }
}