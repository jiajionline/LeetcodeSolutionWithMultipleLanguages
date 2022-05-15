class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return isUnivalTree(root, root.val);
        
    }
    
    private boolean isUnivalTree(TreeNode node, int v) {
        if(node == null) return true;
        if(node.val != v) return false;
        return isUnivalTree(node.left, v) && isUnivalTree(node.right, v);
    }
}