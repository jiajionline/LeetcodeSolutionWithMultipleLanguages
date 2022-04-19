class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // scan count = m + n - 1;
        // even index : up right, odd index : down left
        // x = row < rows ? row : rows-1
        // y = s < row
        int scan = m+n-1;
        int[] ans = new int[m*n];
        int index = 0;
        for(int i=0; i< scan;i++) {
            if( i % 2 == 0) {
                int x = i < m ? i : m-1;
                int y = i < m ? 0 : i - (m-1);
                while(x >= 0 && y < n) {
                    ans[index++] = mat[x--][y++];
                }
            }else{
                int x = i < n ? 0 : i - (n-1);
                int y = i < n ? i : n-1;
                while(x<m && y >= 0) {
                    ans[index++] = mat[x++][y--];
                }
            }
        }
        
        return ans;
    }
}