public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        var m = mat.Length;
        if(m == 0) return mat;
        var n = mat[0].Length;
        
        var ans = new int[m][];
        for(int i=0;i<m;i++)
        {
            ans[i] = new int[n];
            //avoid overflow
            Array.Fill(ans[i], int.MaxValue - 100);
        }
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 0)
                {
                    ans[i][j] = 0;  
                }else{
                    if(i > 0)
                        ans[i][j] = Math.Min(ans[i][j], ans[i-1][j] + 1);
                    if(j > 0)
                        ans[i][j] = Math.Min(ans[i][j], ans[i][j-1] + 1);
                }
            }
        
        for(int i=m-1;i>=0;i--)
            for(int j=n-1;j>=0;j--)
            {
                if(i<m-1)
                    ans[i][j] = Math.Min(ans[i][j], ans[i+1][j] + 1);
                if(j<n-1)
                    ans[i][j] = Math.Min(ans[i][j], ans[i][j+1] + 1);
            }
        
        return ans;
    }
}