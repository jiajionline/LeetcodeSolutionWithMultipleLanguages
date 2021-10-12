public class Solution
{
    public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        int kInfCost = 1 << 30;
        int[] cost = new int[n];
        Array.Fill(cost, kInfCost);
        cost[src] = 0;

        for (int i = 0; i <= k; ++i)
        {
            var tmp = new int[n];
            Array.Copy(cost, tmp, cost.Length);
            foreach (var p in flights)
                tmp[p[1]] = Math.Min(tmp[p[1]], cost[p[0]] + p[2]);
            cost = tmp;
        }

        return cost[dst] >= kInfCost ? -1 : cost[dst];
    }

}