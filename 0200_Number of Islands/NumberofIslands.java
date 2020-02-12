class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null)
            return numIslands;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    check(grid, i, j, grid.length, grid[i].length);
                }
            }
        }

        return numIslands;
    }

    private void check(char[][] grid, int x, int y, int rowLen, int colLen) {
        if (x < 0 || y < 0 || x >= rowLen || y >= colLen)
            return;
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            check(grid, x - 1, y, rowLen, colLen);
            check(grid, x, y - 1, rowLen, colLen);
            check(grid, x + 1, y, rowLen, colLen);
            check(grid, x, y + 1, rowLen, colLen);

        }
    }
}