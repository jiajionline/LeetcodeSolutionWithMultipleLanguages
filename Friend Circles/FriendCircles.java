
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int circles = 0;
        boolean[] visited = new boolean[M.length];
        
        for(int i=0;i<M.length;i++){
        	if(visited[i] == false){
        		DFS(M, visited, i);
        		circles++;
        	}
        }
        
        return circles;
    }
    
    private void DFS(int[][] M, boolean[] visited, int current){
    	for(int j=0;j<M[current].length;j++){
    		if(M[current][j] == 1 && visited[j] == false){
    			visited[j] = true;
    			DFS(M, visited, j);
    		}
    	}
    }
}
