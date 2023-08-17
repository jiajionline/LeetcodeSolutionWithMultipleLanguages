class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return Integer.compare(a[0],b[0]);
        });

        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }

        return true;
    }
}