class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        
        Arrays.sort(points, (int[] a,int[] b) -> {
            if(a[1] < b[1]) return -1;
            else if(a[1] == b[1]) return 0;
            else return 1;
        });
        
        int ans = 1;
        int currEnd = points[0][1];
        
        for(int i=1;i<points.length;i++){
            if(points[i][0] > currEnd){
                ans++;
                currEnd = points[i][1];
            }
        }
        
        return ans;
    }
}