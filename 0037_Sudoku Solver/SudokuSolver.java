class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board)
    {
         for(int i=0;i<board.length;i++)
            for(int j=0;j< board[i].length;j++)
            {
                if(board[i][j] == '.')
                {
                    for(char k='1';k<='9';k++)
                    {
                        if(isValid(board, i, j, k))
                        {
                            board[i][j] = k;
                            if(solve(board)) 
                                return true;
                            else 
                                board[i][j] = '.';
                        }
                    }
                    
                    return false;
                }
            }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        int regionRow = 3 * (row / 3);  //region start row
        int regionCol = 3 * (col / 3);    //region start col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false; //check row
            if (board[row][i] == c) return false; //check column
            if (board[regionRow + i / 3][regionCol + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}