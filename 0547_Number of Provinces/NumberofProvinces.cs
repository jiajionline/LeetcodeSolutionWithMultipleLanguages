public class Solution {
    public int FindCircleNum(int[][] isConnected) {
        if(isConnected == null) return 0;
        var ans = 0;
        var visited = new bool[isConnected.Length];
        
        for(int i=0;i<isConnected.Length;i++){
            if(visited[i] == false){
                DFS(isConnected,i,visited);
                ans++;
            }
        }
        
        return ans;
    }
    
    private void DFS(int[][] isConnected, int current, bool[] visited)
    {
        for(int i=0;i<isConnected[current].Length;i++){
            if(isConnected[current][i] == 1 && visited[i] == false){
                visited[i] = true;
                DFS(isConnected,i,visited);
            }
        }
    }
}