class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i >= 1 && j >= 1 && matrix[i][j] == 1) {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1]));
                }
                
                ans += matrix[i][j];
            }
        }
        return ans;
    }
}