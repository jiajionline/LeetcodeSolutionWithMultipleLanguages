class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[] dirs = {0,1,0,-1,0};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)
                if(DFS(board, i, j, m, n, 0, word, dirs)) return true;
        }
        
        return false;
    }
    
    private boolean DFS(char[][] board, int x, int y, int m, int n, int index, String word, int[] dirs) {
        if(index == word.length()) return true;
        if(x < 0 || y < 0 || x == m || y == n || board[x][y] != word.charAt(index)) return false;
        char c = board[x][y];
        board[x][y] = '#';
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i], dy = y + dirs[i+1];
            if(DFS(board, dx, dy, m, n, index+1, word, dirs)) return true;
        }
        board[x][y] = c;
        
        return false;
    }
}