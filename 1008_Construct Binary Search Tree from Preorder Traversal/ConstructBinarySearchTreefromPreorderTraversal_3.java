class Solution {
    private int index = 0;
    private int[] preorder;
    private int N;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        this.N = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int lower, int upper) {
        if(index == N) return null;
        int val = preorder[index];
        if(val < lower || val > upper) return null;
        index++;
        TreeNode node = new TreeNode(val);
        node.left = helper(lower, val);
        node.right = helper(val , upper);
        return node;
    }
}