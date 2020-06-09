public class Solution
{
    /// Time complexity, O(T * M * N^2)
    /// Space complexity, can be reduced from O(T * M * N) to O(M * N)
    public int MinCost(int[] houses, int[][] cost, int m, int n, int target)
    {
        //initial color starts from 1
        var initialColor = 1;
        //max value for the initialization. Can't put int.MAXVALUE since it might overflow.
        int max = (int)(1e9 + 7);

        //DP[k][i][c], minimal cost to form k neighbors with first i houses and end with color c. 
        //all boundary plus 1 for padding
        var DP = new int[target + 1][][];
        for (int i = 0; i < DP.Length; i++)
        {
            DP[i] = new int[m + 1][];
            for (int j = 0; j < DP[i].Length; j++)
            {
                DP[i][j] = new int[n + 1];
                for (int k = 0; k < DP[i][j].Length; k++)
                {
                    if (i == 0 && j == 0)
                        //initialize 0 when neighbor = 0 and house = 0
                        DP[i][j][k] = 0;
                    else
                        DP[i][j][k] = max;

                }
            }
        }

        for (int k = 1; k <= target; k++)
        {
            for (int i = k; i <= m; i++)
            {
                var currHouseColor = houses[i - 1];
                var prevHouseColor = i >= 2 ? houses[i - 2] : 0;
                // check if the house has been painted, if no (currHouseColor = 0), set 1 to n to scan
                Tuple<int, int> curr = currHouseColor > 0 ? new Tuple<int, int>(currHouseColor, currHouseColor) : new Tuple<int, int>(initialColor, n);
                Tuple<int, int> prev = prevHouseColor > 0 ? new Tuple<int, int>(prevHouseColor, prevHouseColor) : new Tuple<int, int>(initialColor, n);

                //scan the color one step each
                for (int ci = curr.Item1; ci <= curr.Item2; ci++)
                {
                    //cost to paint. If has been painted, the cost is 0, otherwise to fetch the cost
                    int currCost = ci == currHouseColor ? 0 : cost[i - 1][ci - 1];
                    for (int cj = prev.Item1; cj <= prev.Item2; cj++)
                    {
                        DP[k][i][ci] = Math.Min(DP[k][i][ci], DP[k - (ci != cj ? 1 : 0)][i - 1][cj] + currCost);
                    }
                }
            }
        }

        int ans = max;

        for (int i = 0; i < DP[target][m].Length; i++)
        {
            ans = Math.Min(ans, DP[target][m][i]);
        }

        return ans >= max ? -1 : ans;
    }
}