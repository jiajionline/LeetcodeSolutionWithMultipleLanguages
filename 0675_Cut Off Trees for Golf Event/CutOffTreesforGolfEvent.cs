public class Solution
{
    private int[] DR = { -1, 1, 0, 0 };
    private int[] DC = { 0, 0, -1, 1 };
    public int CutOffTree(IList<IList<int>> forest)
    {
        var list = new List<Cell>();

        for (var i = 0; i < forest.Count; i++)
        {
            for (var j = 0; j < forest[i].Count; j++)
            {
                if (forest[i][j] > 1)
                {
                    var cell = new Cell()
                    {
                        Row = i,
                        Col = j,
                        Val = forest[i][j]
                    };

                    list.Add(cell);
                }
            }
        }

        list.Sort((t1,t2) =>  t1.Val.CompareTo(t2.Val));

        var ans = 0;
        var sr = 0;
        var sc = 0;

        foreach (var cell in list)
        {
            var steps = BFS(forest, sr, sc, cell);
            if (steps == -1) return -1;
            ans += steps;
            sr = cell.Row;
            sc = cell.Col;
        }

        return ans;
    }

    private int BFS(IList<IList<int>> forest, int row, int col, Cell cell)
    {
        var queue = new Queue<int[]>();
        queue.Enqueue(new int[] { row, col, 0 });
        var visited = new HashSet<string>();
        while (queue.Count > 0)
        {
            var q = queue.Dequeue();
            if (q[0] == cell.Row && q[1] == cell.Col) return q[2];
            if (q[0] >= 0 && q[0] < forest.Count && q[1] >= 0 && q[1] < forest[row].Count && !visited.Contains(q[0] + "_" + q[1]) && forest[q[0]][q[1]] >= 1)
            {
                visited.Add(q[0] + "_" + q[1]);
                for (int di = 0; di < 4; di++)
                {
                    var newRow = q[0] + DR[di];
                    var newCol = q[1] + DC[di];
                    queue.Enqueue(new int[] { newRow, newCol, q[2] + 1 });
                }
            }
        }

        return -1;
    }
}

public class Cell
{
    public int Row;
    public int Col;
    public int Val;
}