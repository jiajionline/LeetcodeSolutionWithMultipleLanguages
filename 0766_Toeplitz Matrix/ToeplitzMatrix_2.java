class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int col=0;col<n;col++) {
            int v = matrix[0][col];
            int dx = 0;
            int dy = col;
            while(dx < m && dy < n) {
                if(matrix[dx++][dy++] != v) return false;
            }
        }
        
        for(int row = 1; row < m; row++) {
            int v = matrix[row][0];
            int dx = row;
            int dy = 0;
            while(dx < m && dy < n) {
                if(matrix[dx++][dy++] != v) return false;
            }
        }
        
        return true;
    }
}