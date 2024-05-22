class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1_000_000_007;
        int[][][] dp = new int[maxMove+1][m][n];
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int k=1;k<=maxMove;k++) {
            for(int x=0;x<m;x++) {
                for(int y=0;y<n;y++) {
                    for(int d = 0; d<dirs.length;d++) {
                        int dx = x + dirs[d][0];
                        int dy = y + dirs[d][1];
                        if(dx < 0  || dy < 0 || dx == m || dy == n) {
                            dp[k][x][y] += 1;
                        }else{
                            dp[k][x][y] = (dp[k][x][y] + dp[k-1][dx][dy]) % mod;
                        }
                    }
                }
            }
        }

        return dp[maxMove][startRow][startColumn];
    }
}