class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int dir = 2;
        int x = 0;
        int y = 0;
        int row_max = n-1;
        int col_max = n-1;
        int row_min = 1;
        int col_min = 0;
        
        for(int i=1;i<=n*n;i++)
        {
            ans[x][y] = i;
            switch (dir) {
                case 1: //up
                    if(--x == row_min) {
                        dir++;
                        row_min++;
                    }
                    break;
                case 2: //right
                    if(++y == col_max) {
                        dir++;
                        col_max--;
                    }
                    break;
                case 3: //down
                    if(++x == row_max) {
                        dir++;
                        row_max--;
                    }
                    break;
                case 4: //left
                    if(--y == col_min) {
                        dir=1;
                        col_min++;
                    }
                    break;
            }
        }
        
        
        return ans;
    }
}