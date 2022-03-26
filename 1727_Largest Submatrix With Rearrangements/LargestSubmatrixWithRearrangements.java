class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == 1) matrix[i][j] += matrix[i-1][j];     
            }
        }
        
        for(int i=0;i<n;i++) {
            Arrays.sort(matrix[i]);
            
            for(int j=m-1;j>=0;j--) {
                if(matrix[i][j] == 0) break;
                ans = Math.max(ans, matrix[i][j] * (m - j));
            }
        }
        
        return ans;
    }
}