public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //[l, r), lower bound
        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            int total = 0;
            int j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                // also can use binary search here 
                // calculate how many matrix[i][j] is less and equal than mid
                while(j >= 0 && matrix[i][j] > mid) j--;
                //since j is array based index, should add 1 for counting
                total += (j + 1);
            }
            // this is lower bound since we want to find where exactly the k is.
            if(total >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}