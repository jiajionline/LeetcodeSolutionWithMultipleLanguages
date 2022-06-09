class Solution {
    private int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        traverse(root, 1);
        return ans;
    }
    
    private void traverse(TreeNode node, int level) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            ans = Math.min(ans, level);
        }
        
        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }
}