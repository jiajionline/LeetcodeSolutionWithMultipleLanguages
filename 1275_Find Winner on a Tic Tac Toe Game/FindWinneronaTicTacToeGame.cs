public class Solution {
    
    int[] rowSum = new int[3];
    int[] colSum = new int[3];
    
    public string Tictactoe(int[][] moves) {
        
        int diagSum = 0;
        int antiDiagSum = 0;
        for(int i = 0; i < moves.Length; i++)
        {
            int player = i % 2 == 0 ? 1 : -1;
            string play = i % 2 == 0 ? "A" : "B";
            
            rowSum[moves[i][0]] += player;
            colSum[moves[i][1]] += player;
            
            if(moves[i][0] == moves[i][1])
            {
                diagSum += player;
            }
            if(moves[i][0] == (2 - moves[i][1]))
            {
                antiDiagSum += player;
            }
            
            if(Math.Abs(rowSum[moves[i][0]]) == 3 || Math.Abs(colSum[moves[i][1]]) == 3 || Math.Abs(diagSum) == 3 || Math.Abs(antiDiagSum) == 3)
            {
                return play;
            }
        }
        
        return moves.Length == 9 ? "Draw" : "Pending";
    }
}