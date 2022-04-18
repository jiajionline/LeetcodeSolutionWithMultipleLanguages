class Solution {
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return ans;
    }
    
    private int postOrder(TreeNode node) {
        if(node == null) return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}