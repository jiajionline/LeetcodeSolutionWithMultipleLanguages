class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[i].length;j++) {
                if(rooms[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(q.size() > 0) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            // left, up, right, down directions
            for(int i=0;i<dirs.length;i++) {
                int dx = x + dirs[i][0];
                int dy = y + dirs[i][1];
                if(dx < 0 || dy < 0 || dx >= rooms.length || dy >= rooms[0].length || rooms[dx][dy] == 0 || rooms[dx][dy] == -1) continue;
                if(rooms[dx][dy] <= rooms[x][y] + 1) continue;
                rooms[dx][dy] = rooms[x][y] + 1;
                q.offer(new int[]{dx, dy});
            }
        }
    }
}