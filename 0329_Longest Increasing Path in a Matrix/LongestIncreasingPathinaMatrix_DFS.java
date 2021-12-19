class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                ans = Math.max(ans, DFS(matrix, i, j, m, n, memo));
            
        return ans;
    }
    
    private int DFS(int[][] matrix, int x, int y, int m, int n, int[][] memo){
        if(memo[x][y] > 0) return memo[x][y];
        
        int[] dirs = new int[] { 0, -1, 0, 1, 0 };
        memo[x][y] = 1;
        for (int i = 0; i < 4; i++){
            int dx = x + dirs[i];
            int dy = y + dirs[i + 1];
            if(dx < 0 || dy < 0 || dx == m || dy == n || matrix[x][y] >= matrix[dx][dy]) continue;
            memo[x][y] = Math.max(memo[x][y], DFS(matrix, dx, dy, m, n, memo) + 1);
        }
        
        return memo[x][y];
    }
}