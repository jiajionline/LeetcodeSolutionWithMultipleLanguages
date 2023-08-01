class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                // assume the current cup dp[r][c] can fill in the full cup, q means how much overflow to left and right
                double overflow = (dp[r][c] - 1.0) / 2.0;
                // only handle it when overflowing
                if (overflow > 0) {
                    dp[r+1][c] += overflow;
                    dp[r+1][c+1] += overflow;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }
}