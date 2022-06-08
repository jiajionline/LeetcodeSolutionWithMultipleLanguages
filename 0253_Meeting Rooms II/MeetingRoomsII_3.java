class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        List<int[]> list = new ArrayList<>(intervals.length * 2);
        for(int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        
        list.sort((i1, i2) ->  {
            return i1[0] != i2[0] ? Integer.compare(i1[0], i2[0]) : Integer.compare(i1[1], i2[1]);
        });
        
        int cnt = 0;
        int ans = 0;
        for(int[] item : list) {
            cnt += item[1];
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}