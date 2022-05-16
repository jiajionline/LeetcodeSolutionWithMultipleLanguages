class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[] dirs = new int[]{0,1,0,-1,0};
        for(int i=0;i<n;i++) {
            if(board[0][i] == 'O') dfs(board, 0, i, dirs);
            if(board[m-1][i] == 'O') dfs(board, m-1, i, dirs);
        }
        
        for(int i=0;i<m;i++) {
            if(board[i][0] == 'O') dfs(board, i, 0, dirs);
            if(board[i][n-1] == 'O') dfs(board, i, n-1, dirs);
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'M') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int x , int y, int[] dirs) {
        if(x < 0 || y < 0 || x == board.length || y == board[x].length || board[x][y] != 'O') return;
        board[x][y] = 'M';
        
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i];
            int dy = y + dirs[i+1];
            dfs(board, dx, dy, dirs);
        }
    }
}