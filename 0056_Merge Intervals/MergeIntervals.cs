using System;
using System.Collections.Generic;
using System.Linq;
public class Solution
{
    public int[][] Merge(int[][] intervals)
    {
        Array.Sort(intervals, (a, b) => a[0] - b[0]);
        var list = new LinkedList<int[]>();

        foreach (var interval in intervals)
        {
            if(list.Count == 0 || list.Last.Value[1] < interval[0])
            {
                list.AddLast(interval);
            }
            else
            {
                list.Last.Value[1] = Math.Max(list.Last.Value[1], interval[1]);
            }
        }

        return list.ToArray();
    }
}
