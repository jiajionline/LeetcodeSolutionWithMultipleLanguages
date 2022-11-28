class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] copy = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                copy[i][j] = board[i][j];
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int cntOfLive = 0;
                cntOfLive += isLive(copy, i,j-1,m,n);
                cntOfLive += isLive(copy, i-1,j-1,m,n);
                cntOfLive += isLive(copy, i-1,j,m,n);
                cntOfLive += isLive(copy, i-1,j+1,m,n);
                cntOfLive += isLive(copy, i,j+1,m,n);
                cntOfLive += isLive(copy, i+1,j+1,m,n);
                cntOfLive += isLive(copy, i+1,j,m,n);
                cntOfLive += isLive(copy, i+1,j-1,m,n);
                
                if(cntOfLive < 2 || cntOfLive > 3){
                    board[i][j] = 0;
                }else if(cntOfLive == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int isLive(int[][] board, int x, int y, int m, int n) {
        if(x < 0 || y < 0 || x == m || y == n || board[x][y] == 0) return 0;
        return 1;
    }
}