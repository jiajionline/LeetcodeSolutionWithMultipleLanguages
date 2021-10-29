public class Solution
{
    public int OrangesRotting(int[][] grid)
    {
        var dirs = new int[] { 0, -1, 0, 1, 0 };
        var countOfFresh = 0;
        var m = grid.Length;
        var n = grid[0].Length;
        var queue = new Queue<Tuple<int, int>>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 2)
                    queue.Enqueue(Tuple.Create(i, j));
                else if (grid[i][j] == 1)
                    countOfFresh++;
            }

        var ans = 0;
        if(countOfFresh == 0) return ans;
        
        while (queue.Count > 0)
        {
            var count = queue.Count;
            while (count-- > 0)
            {
                var tuple = queue.Dequeue();
                var x = tuple.Item1;
                var y = tuple.Item2;

                for (int i = 0; i < 4; i++)
                {
                    var dx = x + dirs[i];
                    var dy = y + dirs[i + 1];

                    if (dx < 0 || dy < 0 || dx >= m || dy >= n || grid[dx][dy] != 1) continue;
                    grid[dx][dy] = 2;
                    countOfFresh--;
                    queue.Enqueue(Tuple.Create(dx, dy));
                }
            }
            ans++;
            if (countOfFresh == 0) return ans;
        }

        if (countOfFresh > 0) return -1;
        return ans;
    }
}