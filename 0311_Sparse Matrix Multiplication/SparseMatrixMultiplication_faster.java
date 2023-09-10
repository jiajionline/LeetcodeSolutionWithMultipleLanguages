class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length,  n = mat2[0].length;
        int[][] ans = new int[m][n];

        for(int mat1Row = 0 ; mat1Row < m ; mat1Row++) {
            for(int k1 = 0; k1 < k; k1++) {
                if(mat1[mat1Row][k1] != 0) {
                    for(int mat2Col = 0; mat2Col < n; mat2Col++) 
                        ans[mat1Row][mat2Col] += mat1[mat1Row][k1] * mat2[k1][mat2Col];    
                }
            }
        }
        return ans;
    }
}