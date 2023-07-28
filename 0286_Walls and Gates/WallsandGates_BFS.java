class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = rooms.length, n = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(rooms[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int distance = 0;
        while(q.size() > 0) {
            distance++;
            int size = q.size();
            while(size-- > 0) {
                int[] pos = q.poll();
                int x = pos[0], y = pos[1];
                // left, up, right, down directions
                for(int i=0;i<dirs.length;i++) {
                    int dx = x + dirs[i][0];
                    int dy = y + dirs[i][1];
                    if(dx < 0 || dy < 0 || dx >= m || dy >= n || rooms[dx][dy] <= distance) continue;
                    rooms[dx][dy] = distance;
                    q.offer(new int[]{dx, dy});
                }
            }
            
        }
    }
}