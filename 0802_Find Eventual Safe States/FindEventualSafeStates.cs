public class Solution {
    public IList<int> EventualSafeNodes(int[][] graph) {
        var ans = new List<int>();
        if(graph == null) return ans;
        var states = new State[graph.Length];
        for(int i=0;i<states.Length;i++){
            states[i] = State.UNKNOWN;
        }
        
        for(int i=0;i<graph.Length;i++){
            if(DFS(graph, i, states) == State.SAFE){
                ans.Add(i);
            }
        }
        
        ans.Sort();
        
        return ans;
    }
    
    private State DFS(int[][] graph, int v, State[] states)
    {
        if(states[v] == State.VISITING) return State.UNSAFE;
        if(states[v] != State.UNKNOWN) return states[v];
        states[v] = State.VISITING;
        var adjacents = graph[v];
        foreach(var next in adjacents){
            var nextState = DFS(graph, next, states);
            if(nextState == State.UNSAFE){
                states[v] = State.UNSAFE;
                return State.UNSAFE;
            }
        }
        
        states[v] = State.SAFE;
        return State.SAFE;
    }
}


public enum State{
    UNKNOWN, VISITING, UNSAFE, SAFE
}