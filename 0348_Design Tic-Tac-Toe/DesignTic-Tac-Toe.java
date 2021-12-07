public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        if (row == col) 
            diagonal += currentPlayer;
       
        if (col == (cols.length - row - 1)) 
            antiDiagonal += currentPlayer;
        
        int n = rows.length;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }
        
        return 0;
    }
}
