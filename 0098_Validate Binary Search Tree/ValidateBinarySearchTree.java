class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min , long max) {
        if(node == null) return true;
        long v = node.val;
        if(v <= min || v >= max) return false;
        return isValidBST(node.left, min, v) && isValidBST(node.right, v, max);
    }
}