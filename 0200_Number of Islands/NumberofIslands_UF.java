class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = grid.length, n = grid[0].length, ans = 0;
        UF uf = new UF(m * n);
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1'){
                    ans++; // assuming any island is an independent island
                    for(int[] dir : dirs){
                        int dx = i + dir[0], dy = j + dir[1];
                        if(dx >= 0 && dy >=0 && dx < m && dy < n && grid[dx][dy] == '1'){
                            //if find another island, so the island (dx,dy) should connect to the island (i,j)
                            // but if these two not connected before, decrese the answer
                            // top and left should've connected, right and bottom should've not..
                            if(uf.find(dx * n + dy) != uf.find(i * n + j)) ans--;
                            uf.union(dx * n + dy, i * n + j);
                        }
                    }
                }
            }
        }
        return ans;
    }
}

class UF {
    private int[] parent;
    public UF(int n) {
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }
    
    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x , int y){
        parent[find(x)] = find(y);
    }
}