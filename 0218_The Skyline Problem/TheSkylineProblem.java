class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] b : buildings) {
            map.putIfAbsent(b[0], new ArrayList<>());
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int point : map.keySet()) {
            List<int[]> bs = map.get(point);
            for (int[] b : bs) {
                if (b[0] == point) { // entering
                    maxHeap.offer(b);
                } else {  // leaving
                    maxHeap.remove(b);
                }
            }
            
            if (maxHeap.size() == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(point);
                tmp.add(0);
                ans.add(tmp);
            } else {
                int maxHeight = maxHeap.peek()[2];
                
                if (ans.size() == 0 || ans.get(ans.size() - 1).get(1) != maxHeight) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(point);
                    tmp.add(maxHeight);
                    ans.add(tmp);
                }
            }
        }
        
        return ans;
    }
}