class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals) {
            if(newInterval == null || newInterval[0] > interval[1])
                res.add(interval);
            else if(newInterval[1] < interval[0]) {
                res.addAll(List.of(newInterval, interval));
                newInterval = null;
            }else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        if(newInterval != null) res.add(newInterval);
        
        return res.toArray(new int[res.size()][]);
    }
}