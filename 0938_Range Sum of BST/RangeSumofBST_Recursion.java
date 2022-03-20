class Solution {
    private int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return ans;
    }
    
    private void traverse(TreeNode node, int low, int high) {
        if(node == null) return;
        if(low <= node.val && node.val <= high) ans += node.val;
        if(low <= node.val) traverse(node.left, low, high);
        if(node.val <= high) traverse(node.right, low, high);
    }
}