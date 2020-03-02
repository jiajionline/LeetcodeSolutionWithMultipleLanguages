using System;
using System.Collections.Generic;
using System.Linq;
public class Solution {
    public int[][] Insert (int[][] intervals, int[] newInterval) {
        var source = intervals.ToList ();
        int index = -1;
        for (int i = 0; i < source.Count; i++) {
            if (newInterval[0] < source[i][0]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            source.Add (newInterval);
        } else {
            source.Insert (index, newInterval);
        }

        var list = new LinkedList<int[]> ();
        foreach (var interval in source) {
            if (list.Count == 0 || list.Last.Value[1] < interval[0]) {
                list.AddLast (interval);
            } else {
                list.Last.Value[1] = Math.Max (list.Last.Value[1], interval[1]);
            }
        }

        return list.ToArray ();
    }
}