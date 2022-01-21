public class Solution {
    public int[][] Insert(int[][] intervals, int[] newInterval) {
        var n = intervals.Length;
        var list = intervals.ToList();
        
        var l = 0;
        var r = n;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(list[mid][0] > newInterval[0])
                r = mid;
            else
                l = mid + 1;
        }
       
        if(l == n)
            list.Add(newInterval);
        else
            list.Insert(l, newInterval);
        
        var ans = new LinkedList<int[]> ();
        foreach (var interval in list) {
            if (ans.Count == 0 || ans.Last.Value[1] < interval[0])
                ans.AddLast(interval);
            else 
                ans.Last.Value[1] = Math.Max(ans.Last.Value[1], interval[1]);
            
        }

        return ans.ToArray();
        
    }
}