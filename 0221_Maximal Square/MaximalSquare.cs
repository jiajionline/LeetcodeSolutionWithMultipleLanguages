public class Solution {
    public int MaximalSquare (char[][] matrix) {
        var m = matrix.Length;
        if(m == 0) return 0;
        var n = matrix[0].Length;
        int[,] dp = new int[m, n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) 
                    dp[i, j] = matrix[i][j] - '0';
                else if(matrix[i][j] == '1')
                    dp[i, j] = Math.Min(Math.Min(dp[i - 1, j], dp[i - 1, j - 1]), dp[i, j - 1]) + 1;

                ans = Math.Max(dp[i, j], ans);
            }
        }

        return ans * ans;
    }
}