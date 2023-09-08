class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][] dirs = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(ans, DFS(grid, i, j, m, n, dirs));
                }
            }
        }
        return ans;
    }

    private int DFS(int[][] grid, int x, int y, int m, int n, int[][] dirs) {
        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] != 1) return 0;
        grid[x][y] = 2;
        int v = 1;
        for(int i=0;i<dirs.length;i++) {
            int dx = x + dirs[i][0];
            int dy = y + dirs[i][1];
            v += DFS(grid, dx, dy, m, n,dirs);
        }
        return v;
    }
}