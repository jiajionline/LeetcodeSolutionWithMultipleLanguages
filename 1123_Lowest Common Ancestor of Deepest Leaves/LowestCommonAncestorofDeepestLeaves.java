class Solution {
    private int deepest = -1;
    private TreeNode ans;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        traverse(root, 0);
        return ans;
    }
    
    private int traverse(TreeNode node, int depth) {
        if(node == null) return depth - 1;
        int left = traverse(node.left, depth + 1);
        int right = traverse(node.right, depth + 1);
        if(depth > deepest) {
            deepest = depth;
        }
        
        if(left == deepest && right == deepest) ans = node;
        return Math.max(left, right);
    }
}