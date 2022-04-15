class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for(int i=0;i<intervals.length;i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0;
        int ans = 0;
        
        for(int i=0;i<intervals.length;i++) {
            if(starts[i] < ends[end]) ans++;
            else end++;
        }
        
        return ans;
    }
}