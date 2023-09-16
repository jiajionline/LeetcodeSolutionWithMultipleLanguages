class Solution {
    private List<TreeNode> list = new ArrayList<>();
    private int deepestLevel = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        getDeepestNodes(root,1);
        return lowerestCommenAncestor(root, list);
    }

    private void getDeepestNodes(TreeNode node, int level) {
        if(node == null) return;
        if(level >= deepestLevel) {
            if(level > deepestLevel){
                 list.clear();
                 deepestLevel = level;
            }
            list.add(node);
        }
        getDeepestNodes(node.left, level+1);
        getDeepestNodes(node.right, level+1);

    }

    private TreeNode lowerestCommenAncestor(TreeNode node, List<TreeNode> list) {
        if(node == null) return null;
        for(TreeNode n : list) {
            if(node == n) return node;
        }
        TreeNode left = lowerestCommenAncestor(node.left, list);
        TreeNode right = lowerestCommenAncestor(node.right, list);
        if(left != null && right != null) {
            return node;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
    }
}