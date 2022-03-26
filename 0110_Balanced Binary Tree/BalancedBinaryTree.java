class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    private int depth(TreeNode node) {
        if(node == null) return 0;
        int left = depth(node.left);
        if(left < 0) return -1;
        int right = depth(node.right);
        if(right < 0) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}