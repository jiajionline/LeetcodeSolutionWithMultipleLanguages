class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[] dirs = {0,1,0,-1,0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        boolean[][] visited = new boolean[m][n];
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x == destination[0] && y == destination[1]) return true;
            for(int i=0;i<4;i++) {
                int dx = x, dy = y;
                while(dx >= 0 && dy >= 0 && dx < m && dy < n && maze[dx][dy] == 0) {
                    dx += dirs[i];
                    dy += dirs[i+1];
                }
                
                dx -= dirs[i];
                dy -= dirs[i+1];
                
                if(!visited[dx][dy]) {
                    visited[dx][dy] = true;
                    q.offer(new int[]{dx, dy});
                }
            }       
        }
        
        return false;
    }
}