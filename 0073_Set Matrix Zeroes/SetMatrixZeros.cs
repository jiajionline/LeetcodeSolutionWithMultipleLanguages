public class Solution {
    public void SetZeroes(int[][] matrix) {
        if(matrix == null || matrix.Length == 0) return;
        var m = matrix.Length;
        var n = matrix[0].Length;
        
        var rows = new int[m];
        var cols = new int[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0)
                {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            if(rows[i] > 0){
                for(int j=0;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(cols[i] > 0){
                for(int j=0;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}