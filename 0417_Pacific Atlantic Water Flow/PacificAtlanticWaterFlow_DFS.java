class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(heights == null || heights.length == 0) return ans;
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] p = new int[m][n];
        int[][] a = new int[m][n];
        
        
        for(int y=0;y<n; y++) {
            DFS(heights, 0, y, 0, p);
            DFS(heights, m-1, y, 0, a);
        }
        
        for(int x=0; x<m; x++) {
            DFS(heights, x, 0, 0, p);
            DFS(heights, x, n-1, 0, a);
        }
        
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
    
    private void DFS(int[][] heights, int x, int y, int h, int[][] v) {
        if(x < 0 || y < 0 || x == heights.length || y == heights[x].length) return;
        if(v[x][y] > 0 || heights[x][y] < h) return;
        v[x][y] = 1;
        
        DFS(heights, x-1, y, heights[x][y], v);
        DFS(heights, x+1, y, heights[x][y], v);
        DFS(heights, x, y-1, heights[x][y], v);
        DFS(heights, x, y+1, heights[x][y], v);
        
        return;
    }
}