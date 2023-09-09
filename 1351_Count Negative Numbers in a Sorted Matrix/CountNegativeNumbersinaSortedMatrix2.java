class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x = 0 , y = n-1;
        int ans = 0;
        while(x < m && y >= 0) {
            if(grid[x][y] >= 0){
                x++;
            }else{
                ans += (m - x);
                y--;
            }
        }
        return ans;
    }
}