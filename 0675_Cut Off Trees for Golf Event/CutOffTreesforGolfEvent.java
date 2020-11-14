class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList();
        for (int r = 0; r < forest.size(); ++r) {
            for (int c = 0; c < forest.get(0).size(); ++c) {
                int v = forest.get(r).get(c);
                if (v > 1) trees.add(new int[]{v, r, c});
            }
        }

        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0, sr = 0, sc = 0;
        for (int[] tree: trees) {
            int d = bfs(forest, sr, sc, tree[1], tree[2]);
            if (d < 0) return -1;
            ans += d;
            sr = tree[1]; sc = tree[2];
        }
        return ans;
    }
    
    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
    int R = forest.size(), C = forest.get(0).size();
    Queue<int[]> queue = new LinkedList();
    queue.add(new int[]{sr, sc, 0});
    boolean[][] seen = new boolean[R][C];
    seen[sr][sc] = true;
    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        if (cur[0] == tr && cur[1] == tc) return cur[2];
        for (int di = 0; di < 4; ++di) {
            int r = cur[0] + dr[di];
            int c = cur[1] + dc[di];
            if (0 <= r && r < R && 0 <= c && c < C &&
                    !seen[r][c] && forest.get(r).get(c) > 0) {
                seen[r][c] = true;
                queue.add(new int[]{r, c, cur[2]+1});
            }
        }
    }
    return -1;
}
}