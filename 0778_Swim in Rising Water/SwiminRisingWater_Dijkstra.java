class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<Integer> visited = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> grid[a / n][a % n] - grid[b / n][b % n]);
        pq.offer(0);
        int ans = 0;
        
        int[] dirs = new int[]{0,1,0,-1,0};

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int x = k / n, y = k % n;
            ans = Math.max(ans, grid[x][y]);
            // destination
            if (x == n-1 && y == n-1) return ans;

            for (int i = 0; i < 4; i++) {
                int dx = x + dirs[i];
                int dy = y + dirs[i+1];
                int j = dx * n + dy;
                if(dx < 0 || dy < 0 || dx == n || dy == n || visited.contains(j)) continue;
                
                pq.offer(j);
                visited.add(j);
            
            }
        }

        return -1;
    }
}