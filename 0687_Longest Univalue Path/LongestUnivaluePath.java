public class Solution {
    private int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        LUP(root);
        return ans;
    }

    private int LUP(TreeNode node){
        if(node == null) return 0;
        int subL = LUP(node.left);
        int subR = LUP(node.right);
        int l = 0;
        int r = 0;
        if(node.left != null && node.val == node.left.val){
            l = subL + 1;
        }

        if(node.right !=null && node.val == node.right.val){
            r = subR + 1;
        }

        ans = Math.max(ans, l + r);
        return Math.max(l,r);
    }
}