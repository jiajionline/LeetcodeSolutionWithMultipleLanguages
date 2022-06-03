class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] matrix = new int[n][n]; //adjacent matrix
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        for(int i=0;i<n;i++) {
            int nextClose = -1;
            for(int j=0;j<n;j++) {
                if(!visited[j] && (nextClose == -1 || distance[j] < distance[nextClose])) nextClose = j;
            }
            visited[nextClose] = true;
            for(int y=0;y<n;y++) {
                if(!visited[y]) distance[y] = Math.min(distance[y], matrix[nextClose][y]);
            }
        }
        
        return Arrays.stream(distance).sum();
    }
}