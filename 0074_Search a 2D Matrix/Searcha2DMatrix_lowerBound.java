class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        
        int l = 0;
        int r = n * m;
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        
        if(l == m*n) return false;
        if(matrix[l/n][l%n] == target) return true;
        else return false;
    }
}