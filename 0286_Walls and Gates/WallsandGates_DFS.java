class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = rooms.length, n = rooms[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(rooms[i][j] == 0) {
                    DFS(rooms, i, j, m, n, 0, dirs);
                }
            }
        }
    }

    private void DFS(int[][] rooms, int x, int y, int m, int n, int distance, int[][] dirs) {
        if(x < 0 || y < 0 || x >= m || y >= n || rooms[x][y] < distance) return;
        rooms[x][y] = distance;
        for(int i=0;i<dirs.length;i++) {
            int dx = x + dirs[i][0];
            int dy = y + dirs[i][1];
            DFS(rooms, dx, dy, m, n, distance+1, dirs);
        }
    }
}