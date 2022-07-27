class Solution {
    private int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return ans;
    }
    
    private void sumRootToLeaf(TreeNode node, int v) {
        if(node == null) return;
        v = (v << 1);
        v += node.val;
        
        if(node.left == null && node.right == null) ans += v;
        sumRootToLeaf(node.left, v);
        sumRootToLeaf(node.right, v);
    }
}