class Solution {
    public int closestValue(TreeNode root, double target) {
       
        int closest = root.val;
        TreeNode p = root;
        
        while(p!=null)
        {
            closest = Math.abs(p.val - target) < Math.abs(closest - target) ? p.val : closest;
            p = target < p.val ? p.left : p.right;
        }
        
        return closest;
    }
}