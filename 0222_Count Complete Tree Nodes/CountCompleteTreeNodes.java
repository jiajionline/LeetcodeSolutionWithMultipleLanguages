class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if(leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int leftDepth(TreeNode node) {
        int depth = 0;
        TreeNode tmpNode = node;
        while(tmpNode!=null) {
            depth++;
            tmpNode = tmpNode.left;
        }
        
        return depth;
    }
    
    private int rightDepth(TreeNode node) {
        int depth = 0;
        TreeNode tmpNode = node;
        while(tmpNode!=null) {
            depth++;
            tmpNode = tmpNode.right;
        }
        
        return depth;
    }
}