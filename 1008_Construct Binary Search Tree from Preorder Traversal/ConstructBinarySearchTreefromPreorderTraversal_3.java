class Solution {
    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int lower , int upper) {
        if(index >= preorder.length) return null;
        int v = preorder[index];
        if(v < lower || v > upper) return null;
        TreeNode node = new TreeNode(v);
        index++;
        node.left = bstFromPreorder(preorder, lower, v);
        node.right = bstFromPreorder(preorder, v, upper);
        return node;
    }
}