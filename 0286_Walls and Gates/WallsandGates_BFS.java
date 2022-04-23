class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[] dirs = new int[]{0,1,0,-1,0};
        
        Queue<int[]> queue = new ArrayDeque<int[]>();
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(rooms[i][j] == 0)
                    queue.offer(new int[]{i,j});
        
        int distance = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            distance++;
            while(size-- > 0) {
                int[] gate = queue.poll();
                int x = gate[0];
                int y = gate[1];
                
                for(int i=0;i<4;i++) {
                    int x1 = x + dirs[i];
                    int y1 = y + dirs[i+1];
                    
                    if(x1 < 0 || y1 < 0 || x1 == m || y1 == n || rooms[x1][y1] <= distance) continue;
                    rooms[x1][y1] = distance;
                    queue.offer(new int[]{x1,y1});
                }
            }
            
        }    
    }
}