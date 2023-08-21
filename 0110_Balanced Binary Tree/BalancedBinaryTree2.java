class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root).getValue();
    }

    private Pair<Integer,Boolean> checkBalanced(TreeNode node) {
        if(node == null) return new Pair<Integer, Boolean>(0, true);
        Pair<Integer,Boolean> left = checkBalanced(node.left);
        Pair<Integer,Boolean> right = checkBalanced(node.right);
        int depth = Math.max(left.getKey(), right.getKey())+1;
        if(!left.getValue() || !right.getValue() || Math.abs(left.getKey() - right.getKey()) > 1) 
            return new Pair<Integer,Boolean>(depth, false);
        
        return new Pair<Integer,Boolean>(depth, true);
    }
}