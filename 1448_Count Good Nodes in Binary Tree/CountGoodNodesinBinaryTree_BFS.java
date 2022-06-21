class Solution {
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return ans;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode, Integer>(root, Integer.MIN_VALUE));
        while(q.size() > 0) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            int max = p.getValue();
            if(node.val >= max) ans++;
            if(node.left != null) q.offer(new Pair<TreeNode, Integer>(node.left, Math.max(max, node.val)));
            if(node.right != null) q.offer(new Pair<TreeNode, Integer>(node.right, Math.max(max, node.val)));
        }
        
        return ans;
    }
}