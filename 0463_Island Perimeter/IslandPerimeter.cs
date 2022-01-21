public class Solution {
    public int IslandPerimeter(int[][] grid) {
        var ans = 0;
        
        var m = grid.Length;
        var n = grid[0].Length;
        
        var dirs = new int[]{1,0,-1,0,1};
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 0) continue;
                
                ans += 4;
                for(int k=0;k<4;k++)
                {
                    var dx = dirs[k] + i;
                    var dy = dirs[k+1] + j;
                    if(dx >= 0 && dx < m && dy >=0 && dy < n && grid[dx][dy] == 1)
                        ans -=1;
                }
            }
        
        return ans;
    }
}