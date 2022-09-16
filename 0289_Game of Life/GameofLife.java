class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                
                int lives = 0;
                for(int x = Math.max(0,i-1);x< Math.min(m,i+2);x++) {
                    for(int y = Math.max(0,j-1); y < Math.min(n, j+2); y++) {
                        lives += board[x][y] & 1;
                    }
                }
                
                if(lives == 3 || lives - board[i][j] == 3)
                    board[i][j] |= (1 << 1);
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] >>= 1;
            }
        }
    }
}it 