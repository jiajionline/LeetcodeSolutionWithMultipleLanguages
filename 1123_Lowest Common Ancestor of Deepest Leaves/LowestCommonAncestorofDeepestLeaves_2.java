class Solution {
    private Set<Integer> deepestLeaves = new HashSet<>();
    private int deepest = Integer.MIN_VALUE;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findAllDeepestLeaves(root, 0);
        return LCA(root);
    }
    
    private void findAllDeepestLeaves(TreeNode node, int depth) {
        if(node == null) return;
        if(depth >= deepest) {
            if(depth > deepest) {
                deepestLeaves.clear();
                deepest = depth;
            } 
            deepestLeaves.add(node.val);
        }
        
        findAllDeepestLeaves(node.left, depth+1);
        findAllDeepestLeaves(node.right, depth+1);
    }
    
    private TreeNode LCA(TreeNode node) {
        if(node == null) return null;
        if(deepestLeaves.contains(node.val)) return node;
        TreeNode left = LCA(node.left);
        TreeNode right = LCA(node.right);
        if(left != null && right != null) return node;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}