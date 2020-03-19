class Solution {

    private TreeNode prev;
    public void Flatten (TreeNode root) {
        if (root == null) return;
        Flatten (root.right);
        Flatten (root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}