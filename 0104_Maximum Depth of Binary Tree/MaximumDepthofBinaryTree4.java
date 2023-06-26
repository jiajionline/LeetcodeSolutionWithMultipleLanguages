class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int ans = 1;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode,Integer>(root, 1));
        while(q.size() > 0) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            ans = Math.max(ans, depth);
            if(node.left != null) 
                q.offer(new Pair<TreeNode, Integer>(node.left, depth+1));
            
            if(node.right != null) 
                q.offer(new Pair<TreeNode, Integer>(node.right, depth+1));
        }

        return ans;
    }
}