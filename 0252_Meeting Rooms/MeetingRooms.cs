public class Solution {
    public bool CanAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.Length <= 1) return true;
        
        Array.Sort(intervals, (a,b) => {
            return a[0].CompareTo(b[0]);
        });
        
        var curMeeting = intervals[0];
        
        for(int i=1;i<intervals.Length;i++)
        {
            if(curMeeting[1] > intervals[i][0]) return false;
            curMeeting = intervals[i];
        }
            
        return true;
    }
}