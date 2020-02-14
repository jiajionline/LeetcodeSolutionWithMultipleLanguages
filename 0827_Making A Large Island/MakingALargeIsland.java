class Solution {
    public int largestIsland(int[][] grid) {
        if(grid == null) return 0;
        int max = 0;
        Map<Integer,Integer> colorToCount = new HashMap();
        int color = 1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    color++;
                    int c = DFS(grid,i,j,grid.length,grid[i].length,color);
                    colorToCount.put(color,c);
                    max = Math.max(max, c);
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 0){
                    int current = 1;
                    for(int c : getColor(grid,i,j,grid.length,grid[i].length,colorToCount)){
                        current += colorToCount.get(c);
                    }
                    max = Math.max(max, current);
                }
            }
        }
        
        return max;
    }
    
    private int DFS(int[][] grid,int i, int j, int rowLen, int colLen,int color){
        if(i<0 || j<0 || i >=rowLen || j >=colLen || grid[i][j] !=1) return 0;
        grid[i][j] = color;
        
        return  DFS(grid,i-1,j,rowLen,colLen,color) +
                DFS(grid,i,j-1,rowLen,colLen,color) +
                DFS(grid,i+1,j,rowLen,colLen,color) +
                DFS(grid,i,j+1,rowLen,colLen,color) + 1;
        
    }
    
    private HashSet<Integer> getColor(int[][] grid, int i,int j, int rowLen, int colLen,Map<Integer,Integer> colorToCount){
        HashSet<Integer> set = new HashSet();
        
        if(i-1>=0 && j>=0 && colorToCount.containsKey(grid[i-1][j])){
            set.add(grid[i-1][j]);
        }
        
        if(i>=0 && j-1>=0 && colorToCount.containsKey(grid[i][j-1])){
            set.add(grid[i][j-1]);
        }
        
        if(i+1<rowLen && j <colLen && colorToCount.containsKey(grid[i+1][j])){
            set.add(grid[i+1][j]);
        }
        
        
        if(i<rowLen && j+1 <colLen && colorToCount.containsKey(grid[i][j+1])){
            set.add(grid[i][j+1]);
        }
        return set;
    }
}