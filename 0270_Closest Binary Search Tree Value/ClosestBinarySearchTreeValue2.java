class Solution {
    private int ans = 0;
    private double v = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return ans;
    }
    
    private void traverse(TreeNode node, double target) {
        if(node == null) return;
        if(Math.abs(node.val - target) < v) {
            ans = node.val;
            v = Math.abs(node.val - target);
        }
        
        if(v == 0) return;
        
        if(target > node.val) {
            traverse(node.right, target);
        }else {
            traverse(node.left, target);
        }
    }
}