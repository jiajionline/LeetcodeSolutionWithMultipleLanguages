class Solution {
    private int[] dirs = new int[]{0,1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0) return false;
        int n = board[0].length;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(DFS(board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean DFS(char[][] board, String word, int index, int x, int y) {
        if(index == word.length()) return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] != word.charAt(index)) return false;
        char c = board[x][y];
        board[x][y] = '#';
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i];
            int dy = y + dirs[i+1];
            if(DFS(board, word, index+1, dx, dy)) return true;
        }
        board[x][y] = c;
        return false;
    }
}