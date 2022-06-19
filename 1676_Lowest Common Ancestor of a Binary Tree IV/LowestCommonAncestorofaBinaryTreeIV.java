class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for(TreeNode node : nodes) set.add(node.val);
        return dfs(root, set);
    }
    
    private TreeNode dfs(TreeNode node, Set<Integer> set) {
        if(node == null) return null;
        if(set.contains(node.val)) return node;
        TreeNode left = dfs(node.left, set);
        TreeNode right = dfs(node.right, set);
        if(left != null && right != null) return node;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}