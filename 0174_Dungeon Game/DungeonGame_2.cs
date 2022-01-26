public class Solution {
    public int CalculateMinimumHP(int[][] dungeon) {
        var m = dungeon.Length;
        var n = dungeon[0].Length;
        var dp = new int[n+1];
        Array.Fill(dp, int.MaxValue);
        dp[n-1] = 1;
        
        for(int x = m-1;x>=0;x--) {
            for(int y = n-1;y>=0;y--) {
                dp[y] = Math.Max(1, Math.Min(dp[y],dp[y+1]) - dungeon[x][y]);
            }
        }
        
        return dp[0];
    }
}