public class Solution {
    public bool IsValidSudoku(char[][] board) {
        if(board == null) return false;
        var rows = board.Length;
        var cols = board[0].Length;
        
        if(rows != 9 || cols != 9) return false;
        
        var set = new HashSet<string>();
        
        for(int row = 0;row < rows;row++)
        {
            for(int col = 0;col < cols; col++)
            {
                var c = board[row][col];
                if(c == '.') continue;
                if(c - '0' < 1 || c - '0' > 9) return false;
                if( !set.Add($"{c} in rows {row}") || 
                    !set.Add($"{c} in cols {col}") || 
                    !set.Add($"{c} in block {row/3} and {col/3}")){
                        return false;
                }
            }
        }
        
        return true;
        
    }
}