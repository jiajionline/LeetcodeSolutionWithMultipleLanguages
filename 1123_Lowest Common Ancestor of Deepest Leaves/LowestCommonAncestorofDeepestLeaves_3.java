class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = height(root.left);
        int right = height(root.right);
        if(left == right) return root;
        else if(left > right) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }
    
    private int height(TreeNode node) {
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}