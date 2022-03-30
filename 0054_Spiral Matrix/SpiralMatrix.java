class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if(matrix == null) return ans;
        int m = matrix.length;
        if(m == 0) return ans;
        int n = matrix[0].length;
        if(n == 0) return ans;
        
        int sRow = 0, eRow = m-1, sCol = 0, eCol = n-1;
        while(sRow <= eRow && sCol <= eCol) {
            // traverse from left to right
            for(int i=sCol; i <= eCol; i++) {
                ans.add(matrix[sRow][i]);
            }
            
            sRow++;
            
            // traverse from top to bottom
            for(int i=sRow; i<=eRow; i++) {
                ans.add(matrix[i][eCol]);
            }
            
            eCol--;
            
            if(eRow >= sRow) {
                // traverse from right to left
                for(int i=eCol; i>= sCol;i--) {
                    ans.add(matrix[eRow][i]);
                }    
            }
            
            eRow--;
            
            if(eCol >= sCol) {
                // traver from bottom to top
                for(int i=eRow; i>= sRow; i--) {
                    ans.add(matrix[i][sCol]);
                }
            }
            
            
            sCol++;
            
        }
        
        return ans;
    }
}