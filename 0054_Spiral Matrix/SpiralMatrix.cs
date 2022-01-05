public class Solution {
    public IList<int> SpiralOrder(int[][] matrix) {
        var ans = new List<int>();
        var m = matrix.Length;
        if(m == 0) return ans;
        var n = matrix[0].Length;
        
        var sRow = 0;
        var eRow = m - 1;
        var sCol = 0;
        var eCol = n - 1;
        
        while(sRow <= eRow && sCol <= eCol)
        {
            //traverse right
            for(int i=sCol;i<=eCol;i++)
                ans.Add(matrix[sRow][i]);
            
            sRow++;
            
            //traverse down
            for(int i=sRow;i<=eRow;i++)
                ans.Add(matrix[i][eCol]);
            
            eCol--;
            
            if(sRow <= eRow)
            {
                for(int i=eCol;i>=sCol;i--)
                    ans.Add(matrix[eRow][i]);
            }
            
            eRow--;
            
            if(sCol <= eCol)
            {
                for(int i=eRow;i>=sRow;i--)
                    ans.Add(matrix[i][sCol]);
            }
            
            sCol++;
            
        }
        
        return ans;
    }
}