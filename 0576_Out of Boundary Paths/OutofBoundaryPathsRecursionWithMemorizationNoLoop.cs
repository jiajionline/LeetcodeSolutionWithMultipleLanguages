public class Solution
{
    private int mod = (int)Math.Pow(10, 9) + 7;

    public int FindPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {
        var dp = new int[maxMove + 1,m,n];
        
        for (int i=0;i<maxMove + 1; i++)
            for(int j = 0; j < m; j++)
                for (int k = 0; k < n; k++)
                    dp[i, j, k] = int.MinValue;


        return Path(dp, maxMove, startRow, startColumn, m, n);

    }

    private int Path(int[,,] dp, int s, int x, int y, int m, int n)
    {
        // Out of boundary, only one path.
        if (x < 0 || y < 0 || x >= m || y >= n) return 1;
        // Can't move but still in the grid, no path.
        if (s == 0) return 0;

        // cached
        if (dp[s, x, y] != int.MinValue) return dp[s, x, y];

        long ans = 0;

        ans += Path(dp, s-1, x-1, y, m, n);
        ans += Path(dp, s-1, x+1, y, m, n);
        ans += Path(dp, s-1, x, y-1, m, n);
        ans += Path(dp, s-1, x, y+1, m, n);
        ans %= mod;
        dp[s, x, y] = (int)ans;
        return dp[s, x, y];
    }
}