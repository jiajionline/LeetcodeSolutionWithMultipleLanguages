class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        transpose(matrix);
    }
    
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++) {
            for(int j=0;j<n;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
    }
}