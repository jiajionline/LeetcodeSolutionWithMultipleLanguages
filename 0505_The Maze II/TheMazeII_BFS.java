class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        dist[start[0]][start[1]] = 0;
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for(int[] dir : dirs){
                int dx = x, dy = y, steps = 0;
                while(dx + dir[0] >= 0 && dy + dir[1] >= 0 && dx + dir[0] < m && dy + dir[1] < n && maze[dx + dir[0]][dy+dir[1]] != 1){
                    steps++;
                    dx += dir[0];
                    dy += dir[1];
                }
                
                if(dist[x][y] + steps < dist[dx][dy]){
                    dist[dx][dy] = dist[x][y] + steps;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}