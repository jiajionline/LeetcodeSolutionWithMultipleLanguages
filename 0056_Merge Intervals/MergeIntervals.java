class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return intervals;
        
        // sort intervals by starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
		// if end of previous interval is more than the start of current interval then there is a overlap
        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] curr : intervals) {
            //  if list empty or no overlap simply add current interval
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < curr[0])
                mergedIntervals.add(curr);
            // else if overlap exists then merge curren tinterval with the previous interval
            else 
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], curr[1]);
        }
        
        return mergedIntervals.toArray(new int[0][]);
    }
}