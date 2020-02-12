public class Solution {
    public int FindCircleNum(int[][] M) {
        if(M == null) return 0;
        var circles = 0;
        var visited = new bool[M.Length];
        
        for(int i=0;i<M.Length;i++){
            if(visited[i] == false){
                Check(M,i,visited);
                circles++;
            }
        }
        
        return circles;
    }
    
    private void Check(int[][] M, int current, bool[] visited)
    {
        for(int i=0;i<M[current].Length;i++){
            if(M[current][i] == 1 && visited[i] == false){
                visited[i] = true;
                Check(M,i,visited);
            }
        }
    }
}