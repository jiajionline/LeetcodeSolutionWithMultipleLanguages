public class Solution {
    public int KthSmallest(int[][] matrix, int k) {
        var m = matrix.Length;
        var n = matrix[0].Length;
        
        var l = matrix[0][0];
        var r = matrix[m-1][n-1] + 1;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            var total = 0;
            for(int i=0;i<m;i++)
            {
                var j = n - 1;
                while(j >=0 && matrix[i][j] > mid)
                    j--;
                total += (j+1);
            }
            if(total >= k)
                r = mid;
            else
                l = mid +1;
        }
        
        return l;
    }
}