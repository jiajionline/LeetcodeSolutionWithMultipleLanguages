class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = depth(root, true);
        int rightDepth = depth(root, false);
        if(leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int depth(TreeNode node, boolean isLeft) {
        int depth = 0;
        TreeNode tmpNode = node;
        while(tmpNode!=null) {
            depth++;
            tmpNode = isLeft ? tmpNode.left : tmpNode.right;
        }
        
        return depth;
    }
}