class Solution {
    private int max = -1;
    private TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    private int dfs(TreeNode node, int depth) {
        if(node == null) return depth - 1;
        int left = dfs(node.left, depth+1);
        int right = dfs(node.right, depth + 1);
        if(depth > max) max = depth;
        if(left == max && right == max) ans = node;
        return Math.max(left, right);
    }
}