public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        var m = matrix.Length;
        if(m == 0) return false;
        var n = matrix[0].Length;
        
        int row = 0;
        int col = n-1;
        
        while(row < m && col >= 0)
        {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        
        return false;
    }
}