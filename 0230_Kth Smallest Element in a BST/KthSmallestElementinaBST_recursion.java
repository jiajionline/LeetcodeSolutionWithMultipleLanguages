class Solution {
    private int index = 0;
    private int v = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return v;
    }
    
    private void inOrder(TreeNode node, int k) {
        if(node == null) return;
        inOrder(node.left,k);
        index++;
        if(index == k){
            v = node.val;
            return;
        }
        
        inOrder(node.right, k);
    }
}