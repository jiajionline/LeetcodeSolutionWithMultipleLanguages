
class Solution {
	private enum State {UNKNOWN, VISITING, SAFE, UNSAFE};
	
    public List<Integer> eventualSafeNodes(int[][] graph) {
    	List<Integer> ans = new ArrayList<Integer>();
    	if(graph == null) return ans;

    	State[] states = new State[graph.length];    
    	
    	for(int i=0;i<graph.length;i++) {
    		if(DFS(graph, i, states) == State.SAFE) {
    			ans.add(i);
    		}
    	}

    	return ans;
    }
    
    private State DFS (int[][] graph, int curr, State[] states) {
    	if(states[curr] == State.VISITING) {
    		states[curr] = State.UNSAFE;
    	}
    	
    	if(states[curr] == State.SAFE || states[curr] == State.UNSAFE) return states[curr];
    	
    	states[curr] = State.VISITING;
    	
    	for(int v : graph[curr]) {
    		if(DFS(graph, v, states) == State.UNSAFE) {
    			states[curr] = State.UNSAFE;
    			return State.UNSAFE;
    		}
    	}
    	
    	states[curr] = State.SAFE;
    	return State.SAFE;
    	
    }
}