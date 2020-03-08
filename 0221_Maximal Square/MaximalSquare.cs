public class Solution {
    public int MaximalSquare (char[][] matrix) {
        if (matrix == null || matrix.Length == 0) return 0;
        int rowLength = matrix.Length;
        int colLength = matrix[0].Length;
        int[, ] dp = new int[rowLength, colLength];
        int largestSize = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i == 0 || j == 0) {
                    dp[i, j] = matrix[i][j] - '0';
                } else if (matrix[i][j] - '0' == 0) {
                    dp[i, j] = 0;
                } else {
                    dp[i, j] = Math.Min (Math.Min (dp[i - 1, j], dp[i - 1, j - 1]), dp[i, j - 1]) + (matrix[i][j] - '0');
                }

                largestSize = Math.Max (dp[i, j], largestSize);
            }
        }

        return largestSize * largestSize;
    }
}