class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    for(int k=0;k<dirs.length;k++) {
                        int dx = i + dirs[k][0], dy = j + dirs[k][1];
                        if(dx < 0 || dy < 0 || dx == m || dy == n || grid[dx][dy] == 0) ans++;
                    }
                }
            }
        }
        return ans;
    }
}