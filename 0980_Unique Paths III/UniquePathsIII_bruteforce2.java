class Solution {
    private int ans = 0;
    public int uniquePathsIII(int[][] grid) {
        int[] startPoint = new int[2];
        int cntOfEmpty= 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int v = grid[i][j];
                if(v == 1) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                }else if(v == 0){
                    cntOfEmpty++;
                }
            }
        }

        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        dfs(grid, startPoint[0], startPoint[1], m, n, 0, cntOfEmpty+1, new boolean[m][n], dirs);
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int m , int n, int steps, int requireSteps, boolean[][] visited, int[][] dirs) {
        if(x < 0 || y < 0 || x == m || y ==n || grid[x][y] == -1 || visited[x][y]) return;
        if(grid[x][y] == 2){
            if(steps == requireSteps) ans++;
            return;
        }

        visited[x][y] = true;
        for(int i=0;i<dirs.length;i++) {
            int dx = x + dirs[i][0];
            int dy = y + dirs[i][1];
            dfs(grid, dx, dy, m, n, steps+1, requireSteps, visited, dirs);
        }
        visited[x][y] = false;
    }
}