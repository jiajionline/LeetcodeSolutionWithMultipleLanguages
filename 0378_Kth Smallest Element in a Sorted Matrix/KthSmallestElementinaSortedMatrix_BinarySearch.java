class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], r = matrix[m-1][n-1] + 1;
        while(l < r) {
            int mid = (r-l)/2 + l;
            int count = smallerOrEqual(matrix, mid);
            if(count >= k) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    private int smallerOrEqual(int[][] matrix, int v) {
        int count = 0;
        int row = matrix.length-1, col = 0;
        while(row>=0 && col < matrix[0].length) {
            if(matrix[row][col] <= v){
                count+= (row+1);
                col++;
            }else{
                row--;
            }
        }

        return count;
    }
}