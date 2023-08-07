class Solution {
    private int mostLeft = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverse(root, map);
        List<List<Integer>> ans = new ArrayList<>();
        int count = map.size();
        while(count-- > 0) {
            ans.add(map.get(mostLeft++));
        }

        return ans;
    }

    private void traverse(TreeNode root,  Map<Integer, List<Integer>> map) {
        if(root == null) return;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode, Integer>(root, 0));
        while(q.size() > 0) {
            int count = q.size();
            while(count-- > 0) {
                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode n = pair.getKey();
                int verticalLevel = pair.getValue();
                mostLeft = Math.min(mostLeft, verticalLevel);
                map.putIfAbsent(verticalLevel, new ArrayList<Integer>());
                map.get(verticalLevel).add(n.val);
                if(n.left != null) q.offer(new Pair<TreeNode, Integer>(n.left, verticalLevel-1));
                if(n.right != null) q.offer(new Pair<TreeNode, Integer>(n.right, verticalLevel+1));
            }
        }
    }
}