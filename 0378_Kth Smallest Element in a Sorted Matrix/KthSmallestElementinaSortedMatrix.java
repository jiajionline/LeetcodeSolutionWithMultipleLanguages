public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //[l, r), lower bound
        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            int total = 0;
            int j = matrix[0].length - 1;
            if (equalOrSmaller(matrix,mid)<k)
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }
    
    private int equalOrSmaller(int[][] matrix, int val)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int i=n-1, j=0, count = 0;
        while (i>=0 && j<m)
        {
            if (matrix[i][j]<=val)
            {
                count+=(i+1);
                j++;
            }
            else
                i--;                
        }
        return count;
    }
}
