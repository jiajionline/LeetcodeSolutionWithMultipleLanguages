class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        
        int ans = 0;
        int[] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        List<Point> points = new ArrayList<Point>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                Point p = new Point();
                p.x = i;
                p.y = j;
                p.v = matrix[i][j];
                points.add(p);
            }
        
        Collections.sort(points, (a, b) -> Integer.compare(b.v, a.v));
        
        for(Point p : points){
            dp[p.x][p.y] = 1;
            for(int[] dir : dirs){
                int dx = dir[0] + p.x;
                int dy = dir[1] + p.y;
                if(dx < 0 || dy < 0 || dx == m || dy == n || matrix[dx][dy] <= p.v) continue;
                dp[p.x][p.y] = Math.max(dp[p.x][p.y], dp[dx][dy] + 1);
            }
            
            ans = Math.max(ans, dp[p.x][p.y]);
        }
       
        return ans;
    }
}

class Point {
    public int x;
    public int y;
    public int v;
}