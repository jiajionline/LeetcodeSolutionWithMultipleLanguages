class Solution {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        if(root == null) return min;
        minDiffInBST(root.left);
        
        if(prev!=null){
            min = Math.min(min,root.val - prev.val);
        }
        
        prev = root;
        
        minDiffInBST(root.right);
        return min;
    }
}