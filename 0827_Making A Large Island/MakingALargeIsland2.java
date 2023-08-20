class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islandIndex = 2;
        Map<Integer,Integer> islandToCountMap = new HashMap<>();
        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        boolean hasOperation = false;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    // DFS -> grid, x, y, m, n, index, islandToCountMap
                    DFS(grid, i, j, m, n, islandIndex, dirs, islandToCountMap);
                    islandIndex++;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    int count = 1;
                    Set<Integer> visited = new HashSet<>();
                    hasOperation = true;
                    for(int k=0;k<dirs.length;k++) {
                        int dx = i + dirs[k][0];
                        int dy = j + dirs[k][1];
                        if(dx < 0 || dy < 0 || dx == m || dy == n || visited.contains(grid[dx][dy])) continue;
                        if(islandToCountMap.containsKey(grid[dx][dy])) {
                            count += islandToCountMap.get(grid[dx][dy]);
                            visited.add(grid[dx][dy]);
                        }
                    }

                    ans = Math.max(ans, count);
                }
                
            }
        }
        return !hasOperation ? m * n : ans;
    }

    private void DFS(int[][] grid, int x, int y, int m, int n, int islandIndex, int[][] dirs, Map<Integer,Integer> islandToCountMap) {
        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] != 1) return;
        grid[x][y] = islandIndex;
        islandToCountMap.putIfAbsent(islandIndex, 0);
        islandToCountMap.put(islandIndex, islandToCountMap.get(islandIndex) + 1);

        for(int i=0;i<dirs.length;i++) {
            int dx = x + dirs[i][0];
            int dy = y + dirs[i][1];
            DFS(grid, dx, dy, m, n, islandIndex, dirs, islandToCountMap);
        }
    }
}