class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[] dirs = {0,1,0,-1,0};
        int m = heights.length, n = heights[0].length;
        int[][] diffMatrix = new int[m][n];
        for (int[] eachRow : diffMatrix) Arrays.fill(eachRow, Integer.MAX_VALUE);
        diffMatrix[0][0] = 0;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>((a, b) -> (Integer.compare(a.diff, b.diff)));
        boolean[][] visited = new boolean[m][n];
        queue.add(new Cell(0, 0, diffMatrix[0][0]));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == m - 1 && curr.y == n - 1)
                return curr.diff;
            for (int i=0; i<4; i++) {
                int dx = curr.x + dirs[i];
                int dy = curr.y + dirs[i+1];
                if (dx < 0 || dx == m || dy < 0 || dy == n || visited[dx][dy]) continue;
                int currDiff = Math.abs(heights[dx][dy] - heights[curr.x][curr.y]);
                int maxDiff = Math.max(currDiff, diffMatrix[curr.x][curr.y]);
                if (diffMatrix[dx][dy] > maxDiff) {
                    diffMatrix[dx][dy] = maxDiff;
                    queue.add(new Cell(dx, dy, maxDiff));
                }
            }
        }
        return diffMatrix[m - 1][n - 1];
    }
}

class Cell {
    int x;
    int y;
    int diff;

    Cell(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
}