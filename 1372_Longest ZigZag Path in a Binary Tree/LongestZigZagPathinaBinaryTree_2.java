class Solution {
    private int ans = 0;
    public int longestZigZag(TreeNode root) {
        traverse(root, true);
        return ans;
    }
    
    private int traverse(TreeNode node, boolean isLeft) {
        if(node == null) return 0;
        int l = traverse(node.left, true);
        int r = traverse(node.right, false);
        ans = Math.max(ans, Math.max(l,r));
        return isLeft ? r + 1 : l + 1;
    }
}