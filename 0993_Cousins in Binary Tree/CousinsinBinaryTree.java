class Solution {
    
    private Pair<TreeNode, Integer> xNode;
    private Pair<TreeNode, Integer> yNode;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y) return false;
        traverse(root, null, 0, x, y);
        
        return (xNode != null && yNode != null && xNode.getKey() != yNode.getKey() && xNode.getValue().equals(yNode.getValue()));
    }
    
    private void traverse(TreeNode node, TreeNode parent, int level, int x, int y) {
        if(node == null) return;
        if(node.val == x) {
            xNode = new Pair<TreeNode, Integer>(parent, level);
        }
        
        if(node.val == y) {
            yNode = new Pair<TreeNode, Integer>(parent, level);
        }
        
        if(xNode!=null && yNode != null) return;
        traverse(node.left, node, level+1, x, y);
        traverse(node.right, node, level+1, x, y);
    }
}