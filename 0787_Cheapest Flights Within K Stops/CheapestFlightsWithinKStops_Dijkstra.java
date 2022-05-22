class Solution {
    class Pair{
        int v;
        int wt;
        int dist;
        
        Pair(int v, int wt, int dist){
            this.v = v;
            this.wt = wt;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            graph.get(u).add(new Pair(v, wt, 0));
            
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0, -1));
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        
        while(pq.size() > 0){
            Pair p = pq.remove();
            if(p.dist > k || stop[p.v] < p.dist)continue;
            
            stop[p.v] = p.dist;
            if(p.v == dst)return p.wt;

            for(Pair nbr : graph.get(p.v)){
                pq.add(new Pair(nbr.v, p.wt + nbr.wt, p.dist + 1));
                
            }
            
        }
        return -1;
    }
}