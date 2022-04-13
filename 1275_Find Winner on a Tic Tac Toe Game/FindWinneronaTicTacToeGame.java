class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                board[i][j] = ' ';
            }
        }
            
        for(int i=0;i<moves.length;i++) {
            if(i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'A';
            }else {
                board[moves[i][0]][moves[i][1]] = 'B';
            }
        }
        
        if(board[0][0]!= ' ' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) return String.valueOf(board[0][0]);
        if(board[1][0]!= ' ' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) return String.valueOf(board[1][0]);
        if(board[2][0]!= ' ' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) return String.valueOf(board[2][0]);
        if(board[0][0]!= ' ' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) return String.valueOf(board[0][0]);
        if(board[0][1]!= ' ' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) return String.valueOf(board[0][1]);
        if(board[0][2]!= ' ' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) return String.valueOf(board[0][2]);
        if(board[0][0]!= ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return String.valueOf(board[0][0]);
        if(board[0][2]!= ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return String.valueOf(board[0][2]);
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(board[i][j] == ' ') return "Pending";
            }
        }
        
        return "Draw";
    }
}