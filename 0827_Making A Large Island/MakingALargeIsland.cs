public class Solution {
    public int LargestIsland(int[][] grid) {
        if(grid == null) return 0;
        int ans = 0;
        int color = 1;
        // key is color_flag starts from 2, value is the count of the color_flag
        var dict = new Dictionary<int,int>();
        
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[i].Length;j++){
                if(grid[i][j] == 1){
                    color++;
                    var count = DFS(grid,i,j,color);
                    dict.Add(color, count);
                    ans = Math.Max(ans, count);
                }        
            }
        }
        
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[i].Length;j++){
                if(grid[i][j] == 0){
                    var count = ColorCount(grid, i,j,dict);
                    ans = Math.Max(ans, count);
                }        
            }
        }
        
        return ans;
    }
    
    private int DFS(int[][] grid, int x, int y, int color){
        if(x<0 || y<0 || x>=grid.Length || y>= grid[0].Length || grid[x][y] != 1) return 0;
        grid[x][y] = color;
        return 1 + DFS(grid, x-1,y,color)+DFS(grid, x+1,y,color)+DFS(grid, x,y-1,color)+DFS(grid, x,y+1,color);
    }
    
    private int ColorCount(int[][] grid, int x, int y, Dictionary<int,int> dict){
        //remove duplicated color_flag around (x,y)
        var set = new HashSet<int>();
        if((x-1) >=0 && y >=0 && dict.ContainsKey(grid[x-1][y])){
            set.Add(grid[x-1][y]);
        }
        
        if((x+1)<grid.Length && y<grid[0].Length && dict.ContainsKey(grid[x+1][y])){
            set.Add(grid[x+1][y]);
        }
        
        if(x >=0 && (y-1) >=0 && dict.ContainsKey(grid[x][y-1])){
            set.Add(grid[x][y-1]);
        }
        
        if(x< grid.Length && (y+1) < grid[0].Length && dict.ContainsKey(grid[x][y+1])){
            set.Add(grid[x][y+1]);
        }
        
        var count = 1;
        foreach(var color in set){
            count += dict[color];
        }
        
        return count;
        
        
    }
}