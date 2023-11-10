class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int index = 0;
        int[] ans = new int[m * n];
        int x = 0, y = 0;
        boolean goingUp = true;
        while(index < m * n) {
            if(!isOutOfBound(x,y,m,n)) {
                ans[index++] = mat[x][y];
                if(goingUp) {
                    x--;
                    y++;
                }else{
                    x++;
                    y--;
                }
            }else{
                if(goingUp) {
                    x++;
                    y--;
                    if(y == n-1){
                        x++;
                    }else{
                        y++;
                    }
                }else{
                    x--;
                    y++;
                    if(x == m-1){
                        y++;
                    }else{
                        x++;
                    }
                }

                goingUp = !goingUp;
            }
        }

        return ans;
    }

    private boolean isOutOfBound(int x, int y, int m, int n) {
        if(x < 0 || y < 0  || x==m || y == n) return true;
        return false;
    }
}