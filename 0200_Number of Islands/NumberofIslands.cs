public class Solution {
    public int NumIslands(char[][] grid) {
        if(grid == null) return 0;
        var ans = 0;
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[i].Length;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    Scan(grid,i,j);
                }
            }
        }
        
        return ans;
    }
    
    private void Scan(char[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.Length || y >=  grid[0].Length){
            return ; 
        }
        
        if(grid[x][y] == '0') return ;
        grid[x][y] = '0';
        Scan(grid, x-1, y);
        Scan(grid, x+1, y);
        Scan(grid, x, y-1);
        Scan(grid, x, y+1);
    }
}