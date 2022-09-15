class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[] dirs = new int[]{0,1,0,-1,0};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.add(new int[]{i,j});
                }else{
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(queue.size() > 0) {
            int[] item = queue.poll();
            int x = item[0];
            int y = item[1];
            
            for(int i=0;i<4;i++) {
                int dx = x + dirs[i];
                int dy = y + dirs[i+1];
                
                if(dx >= 0 && dy >= 0 && dx < m && dy < n && ans[dx][dy] - 1 > ans[x][y]) {
                    ans[dx][dy] = ans[x][y] + 1;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
        
        return ans;
        
    }
}