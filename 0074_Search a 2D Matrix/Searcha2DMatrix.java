class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        
        int n = matrix[0].length;
        int l = 0;
        int r = m * n;
        
        while(l < r)
        {
            int mid = (r-l)/2 + l;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] > target)
                r = mid;
            else 
                l = mid+1;
        }
        
        l = l-1;
        if(l >= 0 && matrix[l / n][l % n] == target) return true;
        else return false;
    }
}