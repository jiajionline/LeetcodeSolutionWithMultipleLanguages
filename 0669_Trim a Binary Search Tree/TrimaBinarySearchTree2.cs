public class Solution {
    public TreeNode TrimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        var left = TrimBST(root.left, low, high);
        var right = TrimBST(root.right, low, high);
        
        if(root.val < low)
            return right;
        else if(root.val > high) 
            return left;
        else {
             root.left = left;
             root.right = right;
             return root;
        }
            
    }
}