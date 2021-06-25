public class Solution
    {
        private int mod = (int)Math.Pow(10, 9) + 7;
        private int[] dirs = new int[] { -1, 0, 1, 0, -1 };

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

            dp[s, x, y] = 0;

            for(int d = 0; d < 4; d++)
            {
                var dx = x + dirs[d];
                var dy = y + dirs[d + 1];
                dp[s, x, y] = (dp[s, x, y] + Path(dp, s - 1, dx, dy, m, n)) % mod;
            }

            return dp[s, x, y];
        }
    }