class Solution {
    public int closestValue(TreeNode root, double target) {
        double v = Double.MAX_VALUE;
        int ans = 0;
        TreeNode p = root;
        while(p != null) {
            double nodeValue = p.val;
            if(Math.abs(nodeValue - target) == v) {
                ans = Math.min(p.val, ans);
            }else if(Math.abs(nodeValue - target) < v) {
                ans = p.val;
                v = Math.abs(nodeValue - target);
            }
            if(nodeValue >= target) {
                p = p.left;
            }else {
                p = p.right;
            }
        }
        return ans;
    }
}