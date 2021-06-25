public class Solution
    {
        public int FindPaths(int m, int n, int maxMove, int startRow, int startColumn)
        {
            int mod = (int)Math.Pow(10, 9) + 7;
            var dp = new int[maxMove + 1,m,n];
            var dirs = new int[]{ -1,0,1,0,-1};
            for (int s = 1; s <= maxMove; s++)
            {
                for (int x = 0; x < m; x++)
                {
                    for (int y = 0; y < n; y++)
                    {
                        for (int d = 0; d < 4; d++)
                        {
                            var tx = x + dirs[d];
                            var ty = y + dirs[d+1];
                            if (tx < 0 || ty < 0 || tx >= m || ty >= n)
                            {
                                dp[s,x,y] += 1;
                            }
                            else
                            {
                                dp[s,x,y] = (dp[s,x,y] + dp[s - 1,tx,ty]) % mod;
                            }
                        }
                    }
                }
            }

            return dp[maxMove,startRow,startColumn];
        }
    }