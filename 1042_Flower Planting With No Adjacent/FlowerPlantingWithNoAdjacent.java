class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for(int[] path : paths) {
            int g1 = path[0];
            int g2 = path[1];
            graph.get(g1).add(g2);
            graph.get(g2).add(g1);
        }
        
        for(int garden = 1 ; garden <= n; garden++) {
            if(graph.get(garden).size() == 0) {
                ans[garden-1] = 1;
            }else if(ans[garden-1] == 0) {
                DFS(garden, graph, ans);    
            }
            
        }
        
        return ans;
    }
    
    private void DFS(int garden, Map<Integer, List<Integer>> graph, int[] ans) {
        
        for(int ft = 1 ; ft <=4 ; ft++) {
            boolean canColor = true;
            for(int next : graph.get(garden)) {
                if(ans[next-1] == ft) {
                    canColor = false;
                    break;
                }
            }
            
            if(canColor) {
                ans[garden-1] = ft;
                break;
            }
        }
        
        for(int next : graph.get(garden)) {
            if(ans[next-1] == 0) {
                DFS(next, graph, ans);
            }
        }
    }
}