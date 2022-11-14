class Solution {
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
  
      int m = grid.length;
      int n = grid[0].length;
      int ans = 0;
  
      for (int r = 0; r < m; ++r) {
        for (int c = 0; c < n; ++c) {
          if (grid[r][c] == '1') {
            ans++;
            grid[r][c] = '0'; 
            Queue<Integer> queue = new LinkedList<>();
            queue.add(r * n + c);
            while (!queue.isEmpty()) {
              int id = queue.remove();
              int row = id / n;
              int col = id % n;
              //left
              if (row - 1 >= 0 && grid[row-1][col] == '1') {
                queue.add((row-1) * n + col);
                grid[row-1][col] = '0';
              }
              //right
              if (row + 1 < m && grid[row+1][col] == '1') {
                queue.add((row+1) * n + col);
                grid[row+1][col] = '0';
              }
              //up
              if (col - 1 >= 0 && grid[row][col-1] == '1') {
                queue.add(row * n + col-1);
                grid[row][col-1] = '0';
              }
              //down
              if (col + 1 < n && grid[row][col+1] == '1') {
                queue.add(row * n + col+1);
                grid[row][col+1] = '0';
              }
            }
          }
        }
      }
  
      return ans;
    }
  }