class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>(); // scr, (dst, cost)
        Map<Integer, Integer> visited = new HashMap<>(); // city, stops
        for(int[] f : flights) prices.computeIfAbsent(f[0], value -> new HashMap<>()).put(f[1], f[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src, k+1});  // cost, city, step
        while(pq.size() > 0) {
            int[] cur = pq.poll();
            int price = cur[0], city = cur[1], stops = cur[2];
            visited.put(city, stops);
            if(city == dst) return price;
            if(stops > 0) {
                Map<Integer, Integer> neighborsPrice = prices.getOrDefault(city, new HashMap<>());
                for(int nei : neighborsPrice.keySet()) {
                    if(!visited.containsKey(nei) || stops > visited.get(nei))
                        pq.add(new int[]{price + neighborsPrice.get(nei), nei, stops - 1});
                }
            }
        }
        return -1;
    }
}