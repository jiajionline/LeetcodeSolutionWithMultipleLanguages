class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, dfs(matrix,i,j,m,n,memo,dirs));
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] matrix, int x, int y, int m, int n, int[][] memo, int[][] dirs){
        if(memo[x][y] > 0) return memo[x][y];
        memo[x][y] = 1;
        for (int[] d : dirs) {
            int dx = x + d[0];
            int dy = y + d[1];
            if(dx < 0 || dy < 0 || dx == m || dy == n || matrix[x][y] >= matrix[dx][dy]) continue;
            memo[x][y] = Math.max(memo[x][y], dfs(matrix, dx, dy, m, n, memo, dirs) + 1);
        }
        
        return memo[x][y];
    }
}