public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        dijkstra(maze, m, n, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dijkstra(int[][] maze, int m, int n, int[] start, int[][] distance) {
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{start[0],start[1],0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];
            
            if(distance[x][y] < dist) continue;
            
            for(int[] dir : dirs) {
                int dx = x, dy = y, steps = 0;
                while(dx + dir[0] >= 0 && dy + dir[1] >= 0 && dx + dir[0] < m && dy + dir[1] < n && maze[dx + dir[0]][dy+dir[1]] != 1){
                    steps++;
                    dx += dir[0];
                    dy += dir[1];
                }
                
                if (distance[x][y] + steps < distance[dx][dy]) {
                    distance[dx][dy] = distance[x][y] + steps;
                    queue.offer(new int[]{dx, dy, distance[dx][dy]});
                }
            }
        }
    }
}