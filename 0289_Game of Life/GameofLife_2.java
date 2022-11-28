class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int cntOfLive = 0;
                cntOfLive += isLive(board, i,j-1,m,n);
                cntOfLive += isLive(board, i-1,j-1,m,n);
                cntOfLive += isLive(board, i-1,j,m,n);
                cntOfLive += isLive(board, i-1,j+1,m,n);
                cntOfLive += isLive(board, i,j+1,m,n);
                cntOfLive += isLive(board, i+1,j+1,m,n);
                cntOfLive += isLive(board, i+1,j,m,n);
                cntOfLive += isLive(board, i+1,j-1,m,n);
                
                if((cntOfLive == 2|| cntOfLive==3) && (board[i][j] == 1)){
                    board[i][j] |= (1 << 1);
                }else if(cntOfLive == 3 && (board[i][j] == 0)){
                    board[i][j] |= (1 << 1);
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {       
                board[i][j] >>= 1;
            }
        }
    }
    
    private int isLive(int[][] board, int x, int y, int m, int n) {
        if(x < 0 || y < 0 || x == m || y == n) return 0;
        return board[x][y] & 1;
    }
}