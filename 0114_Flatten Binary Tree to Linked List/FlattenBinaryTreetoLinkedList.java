class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(root.right);
        root.right = left;
        root.left = null;
        TreeNode p = root;
        while(p.right!=null) p = p.right;
        p.right = right;
    }
}