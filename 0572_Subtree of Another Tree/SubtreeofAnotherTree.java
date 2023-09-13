class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode nodeA, TreeNode nodeB) {
        if(nodeA == null && nodeB == null) return true;
        if(nodeA == null || nodeB == null || nodeA.val != nodeB.val) return false;
        return isSameTree(nodeA.left, nodeB.left) && isSameTree(nodeA.right, nodeB.right);
    }
}