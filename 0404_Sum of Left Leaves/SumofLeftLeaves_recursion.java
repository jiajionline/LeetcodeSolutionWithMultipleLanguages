class Solution {
    private int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return ans;
        traverse(root.left, true);
        traverse(root.right, false);
        return ans;
    }
    
    private void traverse(TreeNode node, boolean isLeft) {
        if(node == null) return;
        if(node.left == null && node.right == null && isLeft)
            ans += node.val;
        traverse(node.left, true);
        traverse(node.right, false);
    }
}