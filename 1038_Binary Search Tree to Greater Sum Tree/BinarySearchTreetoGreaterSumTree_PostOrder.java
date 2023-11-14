class Solution {
    private int accuSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

      private void traverse(TreeNode node) {
        if(node == null) return;
        traverse(node.right);
        int v = node.val;
        node.val += accuSum;
        accuSum += v;
        traverse(node.left);
    }
}