public class Solution {
    public int MaxPoints(int[][] points) {
        var n = points.Length;
        var ans = 0;
        for(int i=0;i<n;i++) 
        {
            var dict = new Dictionary<Tuple<int,int>, int>();
            var max = 0;
            var same = 1;
            for(int j=i+1;j<n;j++) 
            {
                var p1 = points[i];
                var p2 = points[j];
                if(p1[0] == p2[0] && p1[1] == p2[1])
                    same++;
                else 
                {
                    var slope = GetSlope(p1,p2);
                    if(!dict.ContainsKey(slope)) dict.Add(slope, 0);
                    dict[slope]++;
                    max = Math.Max(max, dict[slope]);    
                }
            }
            ans = Math.Max(ans, max + same);
        }
        return ans;
    }
    
    private Tuple<int,int> GetSlope(int[] p1, int[] p2)
    {
        var dx = p1[0] - p2[0];
        var dy = p1[1] - p2[1];
        //vertical
        if(dx == 0) return Tuple.Create(0, p1[0]);
        //horizontal
        if(dy == 0) return Tuple.Create(p1[1], 0);
        var d = GCD(dx, dy);
        return Tuple.Create(dx/d, dy/d);
    }
    
    private int GCD(int m, int n)
    {
        if(n == 0) return m;
        return GCD(n, m % n);
    }
}