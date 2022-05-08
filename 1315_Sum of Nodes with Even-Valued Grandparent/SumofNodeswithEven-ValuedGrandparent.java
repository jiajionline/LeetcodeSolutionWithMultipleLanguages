class Solution {
    private int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return ans;
    }
    
    private void traverse(TreeNode node) {
        if(node == null) return;
        if(node.val % 2 == 0) {
            if(node.left != null) {
                if(node.left.left != null) this.ans += node.left.left.val;
                if(node.left.right != null) this.ans += node.left.right.val;
            }
            
            if(node.right != null) {
                if(node.right.left != null) this.ans += node.right.left.val;
                if(node.right.right != null) this.ans += node.right.right.val;
            }
        }
        sumEvenGrandparent(node.left);
        sumEvenGrandparent(node.right);
    }
}