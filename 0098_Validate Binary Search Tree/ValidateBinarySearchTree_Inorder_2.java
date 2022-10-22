class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long left, long right) {
        if(node == null) return true;
        boolean valid = isValidBST(node.left, left, node.val);
        if(!valid) return false;
        if(node.val <= left || node.val >= right) return false;
        valid = isValidBST(node.right, node.val, right);
        return valid;
    }
}