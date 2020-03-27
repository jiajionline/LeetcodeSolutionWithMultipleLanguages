public class Solution {
   public bool IsValidSudoku(char[][] board)
   {
       if (board == null) return false;
       int row = board.Length;
       int column = board[0].Length;

       if (row != 9 || column != 9) return false;

       var seen = new HashSet<string>();
       for (int i = 0; i < 9; ++i)
       {
           for (int j = 0; j < 9; ++j)
           {
               char number = board[i][j];
               if(number != '.' && (number - '0'< 0 || number - '9' > 9)) return false;
               if(number == '.') continue;
              
               if (!seen.Add(number + " in row " + i) ||
                   !seen.Add(number + " in column " + j) ||
                   !seen.Add(number + " in block " + i / 3 + "-" + j / 3))
                       return false;
           }
       }
       return true;        
   }
}
