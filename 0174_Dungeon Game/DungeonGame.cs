public class Solution {
    public int CalculateMinimumHP(int[][] dungeon) {
        var m = dungeon.Length;
        var n = dungeon[0].Length;
        var dp = new int[m+1][];
        for(int i=0;i<dp.Length;i++) {
            dp[i] = new int[n+1];
            Array.Fill(dp[i], int.MaxValue);
        }
            
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        
        for(int x = m-1;x>=0;x--) {
            for(int y = n-1;y>=0;y--) {
                dp[x][y] = Math.Max(1, Math.Min(dp[x+1][y],dp[x][y+1]) - dungeon[x][y]);
            }
        }
        
        return dp[0][0];
    }
}