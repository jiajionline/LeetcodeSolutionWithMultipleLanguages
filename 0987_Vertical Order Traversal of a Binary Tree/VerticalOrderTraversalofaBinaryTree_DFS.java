class Solution {
    private int min = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, List<int[]>> map = new HashMap<>();
        dfs(root, 0, 0, map);
        while(map.containsKey(min)) {
            List<int[]> list = map.get(min++);
            Collections.sort(list, (a, b) -> {
                if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });
            List<Integer> res = new ArrayList<>();
            for(int[] item : list) {
                res.add(item[1]);
            }
            ans.add(res);
        }
        
        return ans;
        
    }
    
    private void dfs(TreeNode node, int column, int level, Map<Integer, List<int[]>> map) {
        if(node == null) return;
        map.computeIfAbsent(column, t -> new ArrayList<int[]>());
        map.get(column).add(new int[]{level, node.val});
        min = Math.min(min, column);
        dfs(node.left, column-1, level+1, map);
        dfs(node.right, column+1, level + 1, map);
    }
}