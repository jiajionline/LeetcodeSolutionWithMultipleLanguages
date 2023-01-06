class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int ans = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j, dirs);
                }
            }
        }
        return ans;
    }
    
    private void bfs(char[][] grid, int row, int col, int[][] dirs) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x < 0 || y < 0 || x == grid.length || y == grid[x].length || grid[x][y] != '1') continue;
            grid[x][y] = '0';
            for(int[] dir : dirs) q.offer(new int[]{x + dir[0], y + dir[1]});
        }
    }
}