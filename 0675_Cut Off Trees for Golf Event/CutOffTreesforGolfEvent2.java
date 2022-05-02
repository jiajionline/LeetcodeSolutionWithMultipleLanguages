class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new LinkedList<>();
        int[] dirs = new int[]{0,1,0,-1,0};
        
        for(int i=0;i<forest.size();i++) {
            for(int j=0;j< forest.get(i).size();j++) {
                int height = forest.get(i).get(j);
                if(height > 1) trees.add(new int[]{height, i, j});
            }
        }
        
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        
        int x = 0 , y = 0, ans = 0;
        
        for(int[] tree : trees) {
            int steps = BFS(x, y, tree[1], tree[2], forest, dirs);
            if(steps == -1) return -1;
            ans += steps;    
            x = tree[1];
            y = tree[2];
        }
        
        return ans;
    }
    
    private int BFS(int srcX, int srcY, int descX, int descY, List<List<Integer>> forest, int[] dirs) {
        
        if(srcX == descX && srcY == descY) return 0;
        
        int rows = forest.size(), cols = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{srcX, srcY});
        boolean[][] visited = new boolean[rows][cols];
        visited[srcX][srcY] = true;
        
        int steps = 0;
        
        while(queue.size() > 0) {
            int size = queue.size();
            steps++;
            while(size-- > 0) {
                int[] pos = queue.poll();
                for(int i=0;i<4;i++) {
                    int dx = pos[0] + dirs[i];
                    int dy = pos[1] + dirs[i+1];
                    if(dx < 0 || dy < 0 || dx == rows || dy == cols || visited[dx][dy] || forest.get(dx).get(dy) == 0) continue;
                    if(dx == descX && dy == descY) return steps;
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                }        
            }
        }
        
        return -1;
    }
}