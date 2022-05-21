public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dirs= {0, 1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            int x = s[0], y = s[1];
            if (x == destination[0] && y == destination[1]) return true;
            for (int i=0;i<4;i++) {
                int dx = x + dirs[i];
                int dy = y + dirs[i+1];
                while (dx >= 0 && dy >= 0 && dx < m && dy < n && maze[dx][dy] == 0) {
                    dx += dirs[i];
                    dy += dirs[i+1];
                }
                if (!visited[dx - dirs[i]][dy - dirs[i+1]]) {
                    queue.add(new int[] {dx - dirs[i], dy - dirs[i+1]});
                    visited[dx - dirs[i]][dy - dirs[i+1]] = true;
                }
            }
        }
        return false;
    }
}