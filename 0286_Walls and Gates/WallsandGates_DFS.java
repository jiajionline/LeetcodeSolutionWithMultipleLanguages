class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[] dirs = new int[]{0,1,0,-1,0};
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[i].length;j++) {
                if(rooms[i][j] == 0) {
                    DFS(rooms, i, j, 0, dirs);
                }
            }
        }
    }
    
    private void DFS(int[][] rooms, int x, int y, int step, int[] dirs) {
        if(x < 0 || y < 0 || x == rooms.length || y == rooms[x].length || rooms[x][y] < step) return;
        if(rooms[x][y] == step && step != 0) return;
        rooms[x][y] = step;
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i];
            int dy = y + dirs[i+1];
            DFS(rooms, dx, dy, step + 1, dirs);
        }
    }
}