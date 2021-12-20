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
    
    private boolean isValid(char[][] board, int x, int y, char k){
        for(int i=0;i<9;i++){
            if(board[x][i] == k) return false;
            if(board[i][y] == k) return false;
            if(board[3 * (x/3) + i / 3][3 * (y/3) + i % 3] == k) return false;
        }
        return true;
    }
}