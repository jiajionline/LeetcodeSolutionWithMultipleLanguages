public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination, visited);
    }
    
    private boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] visited) {
        if (visited[x][y]) return false;
        if (x == destination[0] && y == destination[1]) return true;
        visited[x][y] = true;
        
        int r = y + 1, l = y - 1, u = x - 1, d = x + 1;
        
        //right
        while (r < maze[0].length && maze[x][r] == 0) r++;
        if (dfs(maze, x, r - 1, destination, visited)) return true;
        
        //left
        while (l >= 0 && maze[x][l] == 0) l--;                      
        if (dfs(maze, x, l + 1, destination, visited)) return true;
        
        //up
        while (u >= 0 && maze[u][y] == 0) u--;
        if (dfs(maze, u + 1, y, destination, visited)) return true;
        
        //down
        while (d < maze.length && maze[d][y] == 0) d++;
        if (dfs(maze, d - 1, y, destination, visited)) return true;
        
        return false;
    }
}