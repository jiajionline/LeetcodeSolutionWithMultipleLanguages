class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        
        int r = 0;
        int c = n-1;
        
        while(r < m && c >= 0)
        {
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target)
                c--;
            else
                r++;
        }
        
        return false;
    }
}