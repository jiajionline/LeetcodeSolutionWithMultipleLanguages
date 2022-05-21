public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        dijkstra(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dijkstra(int[][] maze, int[] start, int[][] distance) {
        int[] dirs= {0, 1, 0, -1, 0};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{start[0],start[1],0});
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            int x = s[0], y = s[1], dist = s[2];
            
            if(distance[x][y] < dist) continue;
            
            for(int i=0;i<4;i++) {
                int dx = x + dirs[i];
                int dy = y + dirs[i+1];
                int count = 0;
                while (dx >= 0 && dy >= 0 && dx < maze.length && dy < maze[0].length && maze[dx][dy] == 0) {
                    dx += dirs[i];
                    dy += dirs[i+1];
                    count++;
                }
                
                if (distance[x][y] + count < distance[dx - dirs[i]][dy - dirs[i+1]]) {
                    distance[dx - dirs[i]][dy - dirs[i+1]] = distance[x][y] + count;
                    queue.offer(new int[]{dx - dirs[i], dy - dirs[i+1], distance[dx - dirs[i]][dy - dirs[i+1]]});
                }
            }
        }
    }
}