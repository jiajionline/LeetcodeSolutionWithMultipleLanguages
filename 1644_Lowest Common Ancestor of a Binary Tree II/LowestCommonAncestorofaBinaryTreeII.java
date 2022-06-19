class Solution {
    private int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = LCA(root, p, q);
        return count == 2 ? node : null;
    }
    
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(root == p || root == q) {
            count++;
            return root;
        }
        
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}