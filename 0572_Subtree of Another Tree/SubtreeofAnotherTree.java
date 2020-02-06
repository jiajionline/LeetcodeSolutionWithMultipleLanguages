class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s!=null && t!=null && s.val == t.val){
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }else{
            return false;
        }
    }
}