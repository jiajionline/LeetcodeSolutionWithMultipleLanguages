public class Solution {
    public int[][] IntervalIntersection(int[][] firstList, int[][] secondList) {
        var list = new List<int[]>();
        int m = firstList.Length, n = secondList.Length;
        if(m == 0 || n == 0) return list.ToArray();
        int p1 = 0, p2 = 0;
        
        while(p1 < m && p2 < n)
        {
            var start1 = firstList[p1][0];
            var start2 = secondList[p2][0];
            var end1 = firstList[p1][1];
            var end2 = secondList[p2][1];
            
            
            if(Math.Max(start1, start2) <= Math.Min(end1,end2))
                list.Add(new int[]{Math.Max(start1, start2), Math.Min(end1,end2)});
            
            if(end1 <= end2) p1++;
            else p2++;
        }
        
        return list.ToArray();
    }
}