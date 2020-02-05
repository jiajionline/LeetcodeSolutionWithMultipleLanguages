public class Solution {
    public bool IsBalanced(TreeNode root) {
        return CheckBalanced(root) != -1;
    }
    
    private int CheckBalanced(TreeNode node){
        if(node == null) return 0;
        int left = CheckBalanced(node.left);
        if(left == -1) return -1;
        int right = CheckBalanced(node.right);
        if(right == -1) return -1;
        if(Math.Abs(left - right) > 1) return -1;
        return Math.Max(left,right)+1;
    }
}