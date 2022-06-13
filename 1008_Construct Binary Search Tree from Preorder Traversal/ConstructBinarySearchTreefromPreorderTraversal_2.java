class Solution {
    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int bound) {
        if(index == preorder.length || preorder[index] > bound) return null;
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = bstFromPreorder(preorder, node.val);
        node.right = bstFromPreorder(preorder, bound);
        return node;
    }
}