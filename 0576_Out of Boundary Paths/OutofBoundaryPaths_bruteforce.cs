class Solution {
    private static int MODULO = (int)Math.pow(10, 9) + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow < 0 || startColumn < 0 || startRow == m || startColumn == n) return 1;
        if(maxMove == 0) return 0;
        return  (findPaths(m,n,maxMove-1, startRow - 1 , startColumn) +
                findPaths(m,n,maxMove-1,  startRow + 1 , startColumn) + 
                findPaths(m,n,maxMove-1,  startRow, startColumn-1) +
                findPaths(m,n,maxMove-1,  startRow, startColumn+1)) % MODULO;
    }
}