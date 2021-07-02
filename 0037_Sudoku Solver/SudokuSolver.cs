public class Solution {
 public void SolveSudoku(char[][] board)
        {
            if (board == null || board.Length == 0)
                return;
            Solve(board);
        }

        public bool Solve(char[][] board)
        {
            for (int i = 0; i < board.Length; i++)
            {
                for (int j = 0; j < board[0].Length; j++)
                {
                    if (board[i][j] == '.')
                    {
                        for (char c = '1'; c <= '9'; c++)
                        {
                            if (IsValid(board, i, j, c))
                            {
                                board[i][j] = c; //Put c for this cell

                                if (Solve(board))
                                    return true; //If it's the solution return true
                                else
                                    board[i][j] = '.'; //Otherwise go back
                            }
                        }

                        return false;
                    }
                }
            }
            return true;
        }

        private bool IsValid(char[][] board, int row, int col, char c)
        {
            for (int i = 0; i < 9; i++)
            {
                if (board[i][col] == c) return false; //check row
                if (board[row][i] == c) return false; //check column
                if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
            }
            return true;
        }
}