class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        if(m != 9) return false;
        int n = board[0].length;
        if(n != 9) return false;
        
        // Use a binary number to record previous occurrence
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] blocks = new int[n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int ch = board[r][c];
                
                if (ch == '.') {
                    continue;
                }
                int val = ch - '0';
                int pos = 1 << (val - 1);

                // Check the row
                if ((rows[r] & pos) > 0) {
                    return false;
                }
                rows[r] |= pos;

                // Check the column
                if ((cols[c] & pos) > 0) {
                    return false;
                }
                cols[c] |= pos;

                // Check the block
                int idx = (r / 3) * 3 + c / 3;
                if ((blocks[idx] & pos) > 0) {
                    return false;
                }
                blocks[idx] |= pos;
            }
        }
        return true;
    }
}