public class TicTacToe {
    // 0 empty, 1 player1, 2 player2
    private int[,] board;

    public TicTacToe(int n) {
        board = new int[n,n];
    }
    
    public int Move(int row, int col, int player) {
        var n = board.GetLength(0);

        board[row,col] = player;
        
        var win = true;
        //row check
        for(int r = 0; r < n;r++)
            if(board[r, col] != player) win = false;
        
        if(win) return player;
        
        win = true;
        for(int c = 0; c < n;c++)
            if(board[row, c] != player) win = false;
        if(win) return player;
        
        if(row == col)
        {
            win = true;
            for(int r=0;r<n;r++)
                if(board[r,r] != player) win = false;
            if(win) return player;
        }
        
        if(row + col +1 == n)
        {
            win = true;
            for(int r=0;r<n;r++)
                if(board[r,n - r - 1] != player) win = false;
            if(win) return player;
        }
        
        return 0;
            
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.Move(row,col,player);
 */