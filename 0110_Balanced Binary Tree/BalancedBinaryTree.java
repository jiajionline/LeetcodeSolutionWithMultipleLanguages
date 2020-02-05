class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = Depth(root.left);
        int right = Depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int Depth(TreeNode root) {
        if (null == root) return 0;
        int leftMax = Depth(root.left);
        int rightMax = Depth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}