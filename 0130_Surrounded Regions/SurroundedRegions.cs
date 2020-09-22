public class Solution {
    public void Solve(char[][] board) {
        if(board == null || board.Length == 0) return ;
        var m = board.Length;
        var n = board[0].Length;

        for(int i=0;i<m;i++){
            DFS(board, m, n, i, 0); 
            DFS(board, m, n, i, n-1);
        }

        for(int i=0;i<n;i++){
            DFS(board, m, n, 0, i);
            DFS(board, m, n, m-1, i);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'K') board[i][j] = 'O';
            }
        }
    }

    private void DFS(char[][] board,int m, int n, int x, int y){
        if(x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O') return;
        board[x][y] = 'K';
        DFS(board, m, n, x-1, y);
        DFS(board, m, n, x, y-1);
        DFS(board, m, n, x+1, y);
        DFS(board, m, n, x, y+1);
    }
}