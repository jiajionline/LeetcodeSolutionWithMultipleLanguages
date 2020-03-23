public class Solution {
    public int FindMinArrowShots(int[][] points) {
        if(points == null || points.Length == 0) return 0;
        
        Array.Sort(points, (a,b) => a[1] - b[1]);
        
        var ans = 1;
        var currEnd = points[0][1];
        
        for(int i=1;i<points.Length;i++){
            if(points[i][0] > currEnd){
                ans++;
                currEnd = points[i][1];
            }
        }
        
        return ans;
    }
}