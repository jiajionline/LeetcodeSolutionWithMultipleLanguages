public class Solution {
    public bool Exist(char[][] board, string word) {
        if(board == null) return false;
        for(int i=0;i<board.Length;i++){
            for(int j=0;j<board[i].Length;j++){
                if(Search(board,word,i,j,0)) return true;        
            }
        }
        
        return false;
    }
    
    private bool Search(char[][] board,string word, int x,int y, int p){
        if(x<0 || y<0 || x==board.Length || y==board[x].Length || board[x][y] != word[p]) return false;
        //not necessary using this,since the next line always returns false if board[x][y] is '#'
        //if(board[x][y] == '#') return false;
        if(p == word.Length-1) return true;
        char original = board[x][y];
        board[x][y] = '#';
        var result =   Search(board, word, x-1,y,p+1) ||
                       Search(board, word, x+1,y,p+1) ||
                       Search(board, word, x,y-1,p+1) ||
                       Search(board, word, x,y+1,p+1);
        board[x][y] = original;
        return result;
        }
}