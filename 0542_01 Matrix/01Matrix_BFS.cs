public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        var m = mat.Length;
        if(m == 0) return mat;
        var n = mat[0].Length;
        
        var queue = new Queue<int[]>();
        
        var ans = new int[m][];
        for(int i=0;i<m;i++)
        {
            ans[i] = new int[n];
            Array.Fill(ans[i], int.MaxValue);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0) 
                {
                    ans[i][j] = 0;
                    queue.Enqueue(new int[]{i,j});
                }
            }
        }
        
        var dirs = new int[]{1,0,-1,0,1};
        while(queue.Count > 0)
        {
            var points = queue.Dequeue();
            for(int i=0;i<4;i++)
            {
                var dx = points[0] + dirs[i];
                var dy = points[1] + dirs[i+1];
                
                if(dx >= 0 && dy >= 0 && dx < m && dy < n)
                {
                    if(ans[dx][dy] > ans[points[0]][points[1]])
                    {
                        ans[dx][dy] = ans[points[0]][points[1]] + 1;
                        queue.Enqueue(new int[]{dx,dy});
                    }
                        
                }
            }
        }
        
        
        return ans;
    }
}