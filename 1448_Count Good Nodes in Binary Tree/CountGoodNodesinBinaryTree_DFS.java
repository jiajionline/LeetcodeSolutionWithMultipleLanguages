class Solution {
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return ans;
        traverse(root, Integer.MIN_VALUE);
        return ans;
    }
    
    private void traverse(TreeNode node, int max) {
        if(node == null) return;
        if(node.val >= max) ans++;
        traverse(node.left, Math.max(node.val, max));
        traverse(node.right, Math.max(node.val, max));
    }
}