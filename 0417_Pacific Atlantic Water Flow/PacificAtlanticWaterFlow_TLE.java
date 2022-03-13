class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[i].length;j++) {
                if(DFS(heights, i, j, heights[i][j]) == 3) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
    
    private int DFS(int[][] heights, int x, int y, int h) {
        if(x < 0 || y < 0) return 1;
        if(x == heights.length || y == heights[x].length) return 2;
        if(heights[x][y] > h) return 0;
        h = heights[x][y];
        heights[x][y] = Integer.MAX_VALUE;
        int valid = DFS(heights, x-1, y, h) |
                    DFS(heights, x+1, y, h) |
                    DFS(heights, x, y-1, h) |
                    DFS(heights, x, y+1, h);
        heights[x][y] = h;
        return valid;
    }
}