// Naive DFS Solution, TLE
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, m ,n, dirs));
        return ans;
    }
  
    private int dfs(int[][] matrix, int x, int y, int m , int n, int[][] dirs) {
        int ans = 1;
        for (int[] d : dirs) {
            int dx = x + d[0];
            int dy = y + d[1];
            if(dx < 0 || dy < 0 || dx == m || dy == n || matrix[x][y] >= matrix[dx][dy]) continue;
            ans = Math.max(ans, dfs(matrix, dx, dy, m, n, dirs) + 1);
        }
        return ans;
    }
  }