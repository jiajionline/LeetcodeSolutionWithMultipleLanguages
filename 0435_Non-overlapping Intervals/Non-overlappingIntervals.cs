public class Solution {
    public int EraseOverlapIntervals(int[][] intervals) {
        Array.Sort(intervals, (a,b) => {
            if(a[1] < b[1]) return -1;
            else if(a[1] == b[1]) return 0;
            else return 1;
        });
       
        var ans = 0;
        var currEnd = intervals[0][1];
        
        for(int i=1;i<intervals.Length;i++)
        {
            if(intervals[i][0] < currEnd)
            {
                ans++;
            }else{
                currEnd = intervals[i][1];
            }
        }
        
        return ans;
    }
}