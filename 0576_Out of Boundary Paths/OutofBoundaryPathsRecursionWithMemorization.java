class Solution {
    private int mod = (int)Math.pow(10,9) + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[maxMove+1][m][n];
        for(int k=0;k<maxMove+1;k++) {
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    memo[k][i][j] = Integer.MIN_VALUE;
                }
            }
        }
        
        return path(maxMove, m, n, startRow, startColumn, memo, new int[]{0,1,0,-1,0});
    }
    
    private int path(int move, int m, int n, int x, int y, int[][][] memo, int[] dirs) {
        if(x < 0 || y < 0 || x >= m || y >= n) return 1;
        if(move == 0) return 0;
        if(memo[move][x][y] >= 0) return memo[move][x][y];
        
        memo[move][x][y] = 0;
        
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i];
            int dy = y + dirs[i+1];
            memo[move][x][y] = (memo[move][x][y] + path(move-1,m,n,dx,dy, memo, dirs)) % mod;
        }
        
        return memo[move][x][y];
    }
}