class Solution {
    private int ans = 0;
    public int longestZigZag(TreeNode root) {
        traverse(root, 0, true);
        traverse(root, 0, false);
        return ans;
    }
    
    private void traverse(TreeNode node, int depth, boolean isLeft) {
        if(node == null) return;
        ans = Math.max(ans, depth);
        if(isLeft) {
            traverse(node.right, depth+1, false);
            traverse(node.left, 1, true);
        }else{
            traverse(node.left, depth+1, true);
            traverse(node.right, 1, false);
        }
    }
}