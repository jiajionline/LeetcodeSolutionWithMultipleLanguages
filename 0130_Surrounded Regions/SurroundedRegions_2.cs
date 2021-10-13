public class Solution {
    public void Solve(char[][] board) {
        for(int i=0;i<board.Length;i++)
            for(int j=0;j<board[i].Length;j++)
            {
                if(i == 0 || j == 0 || i == board.Length-1 || j == board[i].Length-1)
                {
                    BFS(board, i, j , 'O', 'K');
                }
            }
        
        for(int i=0;i<board.Length;i++)
            for(int j=0;j<board[i].Length;j++)
            {
                BFS(board, i, j , 'O', 'X');
            }
        
        
        for(int i=0;i<board.Length;i++)
            for(int j=0;j<board[i].Length;j++)
            {
                BFS(board, i, j , 'K', 'O');
            }
    }
    
    private void BFS(char[][] board, int x, int y, char source, char changeTo)
    {
        if(x < 0 || y < 0 || x >= board.Length || y >= board[x].Length || board[x][y] != source) return;
        board[x][y] = changeTo;
        BFS(board, x-1, y, source, changeTo);
        BFS(board, x+1, y, source, changeTo);
        BFS(board, x, y-1, source, changeTo);
        BFS(board, x, y+1, source, changeTo);
    }
}