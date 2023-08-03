class TicTacToe {
    private int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(checkWin(row,col, player)) return player;
        return 0;
    }

    private boolean checkWin(int row, int col, int player) {
        int n = board.length;
        boolean rowWin = true;
        boolean colWin = true;
        boolean diagWin = true;
        boolean antiDiagWin = true;
        for(int i=0;i<n;i++) {
            //check row
            if(board[i][col] != player) rowWin = false;
            // check col
            if(board[row][i] != player) colWin = false;
            // check diag
            if(row == col) {
                if(board[i][i] != player) diagWin = false;
            }else{
                diagWin = false;
            }
            // check antidiag
            if(row == n - col - 1) {
                if(board[i][n-i-1] != player) antiDiagWin = false;
            }else{
                 antiDiagWin = false;
            }
        }
        return rowWin || colWin || diagWin || antiDiagWin;
    }
}