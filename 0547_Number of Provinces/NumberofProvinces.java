
public class FriendCircles {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        
        for(int i=0;i<isConnected.length;i++){
        	if(visited[i] == false){
        		DFS(isConnected, visited, i);
        		ans++;
        	}
        }
        
        return ans;
    }
    
    private void DFS(int[][] isConnected, boolean[] visited, int current){
    	for(int j=0;j<isConnected[current].length;j++){
    		if(isConnected[current][j] == 1 && visited[j] == false){
    			visited[j] = true;
    			DFS(isConnected, visited, j);
    		}
    	}
    }
}
