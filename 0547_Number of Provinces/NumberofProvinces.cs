public class Solution
{
    public int FindCircleNum(int[][] isConnected)
    {
        var ans = 0;
        if (isConnected == null) return ans;

        var visited = new bool[isConnected.Length];
        for (int i = 0; i < isConnected.Length; i++)
        {
            if (!visited[i])
            {
                ans++;
                DFS(isConnected, visited, i);
            }
        }

        return ans;
    }

    private void DFS(int[][] isConnected, bool[] visited, int i)
    {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < isConnected[i].Length; j++)
        {
            if (isConnected[i][j] == 1 && !visited[j])
            {
                DFS(isConnected, visited, j);
            }
        }
    }
}