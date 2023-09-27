class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int row=1;row<m;row++) {
            for(int col=0;col<n;col++) {
                   int leftTop = col == 0 ? Integer.MAX_VALUE : matrix[row-1][col-1];
                   int top = matrix[row-1][col];
                   int rightTop = col == n-1 ? Integer.MAX_VALUE : matrix[row-1][col+1];
                   matrix[row][col] += ( Math.min(leftTop, Math.min(top, rightTop)));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            ans = Math.min(ans, matrix[m-1][i]);
        }
        return ans;
    }
}