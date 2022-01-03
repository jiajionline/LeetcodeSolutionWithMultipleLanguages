public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        var m = matrix.Length;
        if(m == 0) return false;
        
        var n = matrix[0].Length;
        var l = 0;
        var r = m * n;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(matrix[mid/n][mid%n] > target)
                r = mid;
            else 
                l = mid+1;
        }
        
        l = l-1;
        if(l >= 0 && matrix[l/n][l%n] == target) return true;
        else return false;
    }
}