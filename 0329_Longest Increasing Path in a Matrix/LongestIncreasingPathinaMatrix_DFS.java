class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int[] dirs = new int[]{0,1,0,-1,0};
        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                ans = Math.max(ans, DFS(matrix, i, j, m, n, memo, dirs));
            }
        }
        
        return ans;
    }
    
    private int DFS(int[][] matrix, int x, int y, int m, int n, int[][] memo, int[] dirs) {
        
        if(memo[x][y] > 0) return memo[x][y];
        
        memo[x][y] = 1;
        
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i], dy = y + dirs[i+1];
            if(dx < 0 || dy < 0 || dx == m || dy == n || matrix[x][y] >= matrix[dx][dy]) continue;
            memo[x][y] = Math.max(memo[x][y], 1 + DFS(matrix, dx, dy, m, n, memo, dirs));
        }
        
        return memo[x][y];
    }
}