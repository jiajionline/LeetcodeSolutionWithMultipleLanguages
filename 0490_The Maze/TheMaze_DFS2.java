class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        if(dfs(maze, m, n, start[0], start[1], destination, visited, dirs)) return true;
        return false;
    }
    
    private boolean dfs(int[][] maze, int m, int n, int x, int y, int[] destination, boolean[][] visited, int[][] dirs) {
        if(x == destination[0] && y == destination[1]) return true;
        if(visited[x][y]) return false;
        visited[x][y] = true;
        for(int i=0;i<dirs.length;i++) {
            int dx = x, dy = y;
            while(dx >= 0 && dy >= 0 && dx < m && dy < n && maze[dx][dy] == 0){
                dx += dirs[i][0];
                dy += dirs[i][1];
            }
            
            dx -= dirs[i][0];
            dy -= dirs[i][1];
            if(dfs(maze, m, n, dx, dy, destination, visited, dirs)) return true;
        }
        
        return false;
    }
}