class Solution {
    private static final int TOP5 = 5;
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int[] item : items) {
            int id = item[0];
            int score = item[1];
            map.putIfAbsent(id, new PriorityQueue<Integer>());
            
            PriorityQueue<Integer> pq = map.get(id);
            pq.add(score);
            if(pq.size() > TOP5) pq.poll();
        }
        
        int[][] ans = new int[map.size()][2];
        
        int index = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            int sum = 0;
            for(int i=0;i<TOP5;i++) sum += pq.poll();
            ans[index][0] = id;
            ans[index][1] = (int)(sum/5);
            index++;
        }
        
        return ans;
    }
}