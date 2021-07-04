/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode TrimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        var left = TrimBST(root.left, low, high);
        var right = TrimBST(root.right, low, high);
        root.left = left;
        root.right = right;
        
        if(root.val < low)
            return right;
        else if(root.val > high) 
            return left;
        else
            return root;
    }
}