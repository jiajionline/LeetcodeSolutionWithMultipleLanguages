class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        int[][] ans = new int[m][n];
        
        for(int row = 0;row<m;row++) {
            for(int col = 0; col < n; col++) {
                int v = 0;
                for(int i = 0 ; i<k;i++) {
                    v += mat1[row][i] * mat2[i][col];
                }
                
                ans[row][col] = v;
            }
        }
        
        return ans;
    }
}