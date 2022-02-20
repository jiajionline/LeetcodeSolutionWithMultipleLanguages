public class Solution {
    public int FindCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.Length == 0) return 0;
        var visited = new bool[isConnected.Length];
        var ans = 0;
        
        for(int i=0;i<isConnected.Length;i++) 
        {
            if(!visited[i]) 
            {
                ans++;
                DFS(isConnected, visited, i);
            }
        }
        
        return ans;
    }
    
    private void DFS(int[][] isConnected, bool[] visited, int i)
    {
        if(visited[i]) return;
        visited[i] = true;
        for(int j=0;j<isConnected[i].Length;j++) 
        {
            if(isConnected[i][j] == 1)
                DFS(isConnected, visited, j);
        }
    }
}