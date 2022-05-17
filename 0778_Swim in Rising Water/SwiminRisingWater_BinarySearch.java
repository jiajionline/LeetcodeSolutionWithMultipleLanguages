class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dirs = new int[]{0,1,0,-1,0};
        int l = grid[0][0], r = n * n;
        while (l < r) {
            int mid = (r-l)/2 + l;
            if (!hasPath(mid, grid, dirs)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public boolean hasPath(int T, int[][] grid, int[] dirs) {
        int n = grid.length;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (queue.size()>0) {
            int k = queue.poll();
            int x = k / n, y = k % n;
            if (x == n-1 && y == n-1) return true;

            for (int i = 0; i < 4; i++) {
                int dx = x + dirs[i];
                int dy = y + dirs[i+1];
                int j = dx * n + dy;
                if(dx < 0 || dy < 0 || dx == n || dy == n || grid[dx][dy] > T || visited.contains(j)) continue;
                queue.add(j);
                visited.add(j);
            }
        }

        return false;
    }
}