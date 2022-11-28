class Solution {
    private boolean foundP = false;
    private TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        inOrderTraversal(root, p);
        return ans;
    }
    
    private void inOrderTraversal(TreeNode node, TreeNode p) {
        if(node == null) return;
        inOrderTraversal(node.left, p);
        if(ans != null) return;
        if(foundP) {
            ans = node;
            return;
        }
        if(node.val == p.val){
            foundP = true;
        }
        
        inOrderTraversal(node.right, p);
    }
}