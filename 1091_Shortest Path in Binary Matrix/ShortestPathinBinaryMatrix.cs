public class Solution {
    public int ShortestPathBinaryMatrix(int[][] grid) {
        var m = grid.Length;
        if(m == 0) return -1;
        var n = grid[0].Length;
        if(grid[0][0] != 0) return -1;
        if(grid[m-1][n-1] != 0) return -1;
        if(m == 1 && n == 1) return 1;
        
         var ans = 0;
        var queue = new Queue<int[]>();
        queue.Enqueue(new int[]{0,0});
        grid[0][0] = 1;
        
        var dirs_x = new int[]{-1,-1, 0, 1,1,1,0,-1};
        var dirs_y = new int[]{ 0,-1,-1,-1,0,1,1, 1};
        
        while(queue.Count() > 0)
        {
            ans++;
            var c = queue.Count();
            while(c-- > 0)
            {
                var pos = queue.Dequeue();
                for(int i=0;i<8;i++)
                {
                    var dx = pos[0] + dirs_x[i];
                    var dy = pos[1] + dirs_y[i];
                    
                    if(dx < 0 || dy < 0 || dx == m || dy == n || grid[dx][dy] != 0) continue;
                    if(dx == m-1 && dy == n-1) return ans+1;
                    grid[dx][dy] = 1;
                    queue.Enqueue(new int[]{dx, dy});
                }
            }
        }
        
        return -1;
    }
}