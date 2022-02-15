public class Solution {
    public bool ValidTicTacToe(string[] board)
    {
        if (board == null || board.Length != 3) return false;

        int countX = 0;
        int countO = 0;
        foreach(var line in board)
        {
            if (string.IsNullOrEmpty(line) || line.Length != 3) return false;           	 
            countO += line.Count(c => c == 'O');
            countX += line.Count(c => c == 'X');
        }

        if (countX != (countO + 1) && countX != countO) return false;
        if (Win(board, 'X') && (countO + 1) != countX) return false;
        if (Win(board, 'O') && (countO != countX)) return false;
        return true;
    }

    private bool Win(string[] board, char P)
    {
        for(int i = 0; i < 3; i++)
        {
            if (P == board[0][i] && P == board[1][i] && P == board[2][i]) return true;
            if (P == board[i][0] && P == board[i][1] && P == board[i][2]) return true;           	 
        }

        if (P == board[0][0] && P == board[1][1] && P == board[2][2]) return true;
        if (P == board[0][2] && P == board[1][1] && P == board[2][0]) return true;

        return false;
    }
}