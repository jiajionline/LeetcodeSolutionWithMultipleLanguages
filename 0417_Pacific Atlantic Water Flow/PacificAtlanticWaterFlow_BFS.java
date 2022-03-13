class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(heights == null || heights.length == 0) return ans;
        
        int[] dirs = new int[]{0,-1,0,1,0};
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] p = new int[m][n];
        int[][] a = new int[m][n];
        
        Queue<int[]> queueP = new LinkedList<int[]>();
        Queue<int[]> queueA = new LinkedList<int[]>();
        
        for(int y=0;y<n; y++) {
            queueP.add(new int[]{0,y});
            queueA.add(new int[]{m-1,y});
        }
        
        for(int x=0; x<m; x++) {
            queueP.add(new int[]{x,0});
            queueA.add(new int[]{x,n-1});
        }
        
        BFS(queueP, heights, m, n, p, dirs);
        BFS(queueA, heights, m, n, a, dirs);
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(p[i][j] > 0 && a[i][j] > 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
                    
            }
        }
        
        return ans;
    }
    
    private void BFS(Queue<int[]> queue, int[][] heights, int m, int n, int[][] v, int[] dirs) {
        while(queue.size() > 0) {
            int[] item = queue.poll();
            int x = item[0];
            int y = item[1];
            int h = heights[x][y];
            v[x][y] = 1;
            for(int i=0;i<4;i++) {
                int tx = x + dirs[i];
                int ty = y + dirs[i+1];
                if (tx < 0 || ty < 0 || tx == m || ty == n || heights[tx][ty] < h) continue;
                if (v[tx][ty] > 0) continue;
                queue.add(new int[]{tx,ty});
            }
        }
    }
}