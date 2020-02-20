class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        //padding
        int[][] hp = new int[m+1][n+1];
        for(int i=0;i<hp.length;i++){
            for(int j=0;j<hp[i].length;j++){
                hp[i][j] = Integer.MAX_VALUE;
            }
        }

        hp[m][n-1] = 1;
        hp[m-1][n] = 1;

        for(int x = m-1;x>=0;x--){
            for(int y = n-1;y>=0;y--){
                hp[x][y] = Math.max(1, Math.min(hp[x+1][y],hp[x][y+1]) - dungeon[x][y]);
            }
        }

        return hp[0][0];
    }
}