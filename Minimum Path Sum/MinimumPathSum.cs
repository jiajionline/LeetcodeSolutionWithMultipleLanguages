using System;

namespace LeetcodePracticeCsharpVersion
{
    class MinimumPathSum
    {
        public int MinPathSum(int[,] grid)
        {
            var m = grid.GetLength(0);
            var n = grid.GetLength(1);

            int[,] dpArray = new int[m, n];

            dpArray[0, 0] = grid[0, 0];

            for(int i = 1; i < n; i++)
            {
                dpArray[0, i] = dpArray[0, i - 1] + grid[0, i];
            }

            for(int i = 1; i < m; i++)
            {
                dpArray[i, 0] = dpArray[i - 1, 0] + grid[i, 0];
            }

            for(int i = 1; i < m; i++)
            {
                for(int j = 1; j < n; j++)
                {
                    dpArray[i, j] = grid[i, j] + Math.Min(dpArray[i - 1, j], dpArray[i, j - 1]);
                }
            }

            return dpArray[m - 1, n - 1];
        }
    }
}
