class Solution {
    private int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) {
                    return level;
                }
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return -1;
    }
}