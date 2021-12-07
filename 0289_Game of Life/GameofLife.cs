public class Solution {
    public void GameOfLife(int[][] board) {
        var m = board.Length;
        var n = board[0].Length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                var lives = 0;
                for(int x = Math.Max(0, i-1); x < Math.Min(m, i+2); x++)
                    for(int y = Math.Max(0, j-1); y < Math.Min(n, j+2); y++)
                    {
                        lives += board[x][y] & 1;
                    }
                if(lives == 3 || lives - board[i][j] == 3) 
                    board[i][j] |= (1 << 1);
            }
        }
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                board[i][j] >>= 1;
        
    }
}

