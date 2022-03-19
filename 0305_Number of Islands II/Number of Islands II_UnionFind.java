class Solution {
    private class UnionFind {
        int[] parent;
        int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
        }
        
        public boolean union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return false;
            }
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }
            return true;
        }
        
        public int find(int index) {
            while (index != parent[index]) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0].length == 0) {
            return ans;
        }
        int[] DIRS = {0,1,0,-1,0};
        UnionFind uf = new UnionFind(m * n);
        int count = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int p = x * n + y;
            if (uf.parent[p] != -1) {   // duplicate position
                ans.add(count);
                continue;
            }
            uf.parent[p] = p;
            count++;
            for (int i=0;i<4;i++) {
                int r = x + DIRS[i];
                int c = y + DIRS[i+1];
                if (isValid(uf, m, n, r, c)) {
                    int q = r * n + c;
                    if (uf.union(p, q)) {
                        count--;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    
    private boolean isValid(UnionFind uf, int m, int n, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || uf.parent[r * n + c] == -1) {
            return false;
        }
        return true;
    }
}