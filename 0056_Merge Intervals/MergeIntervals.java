class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] curr : intervals) {
            if(list.isEmpty() || list.getLast()[1] < curr[0])
                list.add(curr);
            else 
                list.getLast()[1] = Math.max(list.getLast()[1], curr[1]);
        }
        
        return list.toArray(new int[list.size()][]);
    }
}