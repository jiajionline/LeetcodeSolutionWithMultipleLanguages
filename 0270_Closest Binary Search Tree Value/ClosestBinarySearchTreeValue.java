class Solution {
    public int closestValue(TreeNode root, double target) {
        int ans = Integer.MAX_VALUE;
        double closest = Double.MAX_VALUE;
        TreeNode p = root;
        while(p != null) {
            if(Math.abs(target - p.val) < closest) {
                ans = p.val;
                closest = Math.abs(target - p.val);
            }
            
            if(p.val >= target){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        
        return ans;
    }
}