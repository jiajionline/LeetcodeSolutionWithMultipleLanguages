class Solution {
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int[][][] memo = new int[n][n][n];
        for (int[][] layer: memo)
            for (int[] row: layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        
        return Math.max(0, dp(n-1,n-1,n-1,grid, memo));
    }
    
    private int dp(int x1, int y1, int x2, int[][] grid, int[][][] memo) {
        int y2 = x1 + y1 - x2;
        // out of boundary 
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return -1;
        // block the way, no answer
        if(grid[x1][y1] < 0 || grid[x2][y2] < 0) return -1;
        //both p1 & p2 reaches (0,0), but only one can pick
        if(x1 == 0 && y1 == 0) return grid[x1][y1];
        //already got the answer
        if(memo[x1][y1][x2] != Integer.MIN_VALUE) return memo[x1][y1][x2];
        int ans = Math.max(Math.max(dp(x1-1,y1,x2-1, grid, memo), dp(x1,y1-1,x2, grid, memo)), 
                           Math.max(dp(x1-1,y1,x2, grid, memo), dp(x1,y1-1,x2-1, grid, memo)));
        
        // no answer
        if(ans < 0) {
            memo[x1][y1][x2] = ans;
            return ans;
        }

        //pick up the cherry for p1
        ans += grid[x1][y1];
        //if p1 and p2 are not standing on the same cell, pick up the cherry for p2
        if(x1 != x2) ans += grid[x2][y2];
        //cache the answer
        memo[x1][y1][x2] = ans;
        return ans;
    }
}