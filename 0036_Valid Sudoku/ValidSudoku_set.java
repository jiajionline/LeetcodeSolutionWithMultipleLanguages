class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        if(m != 9) return false;
        int n = board[0].length;
        if(n != 9) return false;
        
        HashSet<String> set = new HashSet();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                char c = board[i][j];
                if(c == '.') continue;
                String row = "row_" + i + "_" + c;
                String col = "col_" + j + "_" + c;
                String block ="block_" + (i/3) + "_" + (j/3) + "_" + c;
                    
                if(!set.add(row) || !set.add(col) || !set.add(block)) return false;
            }
        }
        
        return true;
    }
}