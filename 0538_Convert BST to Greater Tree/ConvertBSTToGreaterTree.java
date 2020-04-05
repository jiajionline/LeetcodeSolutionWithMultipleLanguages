class Solution {
    private int accumulatedVal = 0;
    public TreeNode convertBST(TreeNode root) {
        PostOrder(root);
        return root;
    }
    
    private void PostOrder(TreeNode node){
        if(node == null) return;
        PostOrder(node.right);
        node.val += accumulatedVal;
        accumulatedVal = node.val;
        PostOrder(node.left);
    }
}