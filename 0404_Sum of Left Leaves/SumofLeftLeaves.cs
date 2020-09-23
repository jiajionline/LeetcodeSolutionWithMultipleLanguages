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
    public int SumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return SumOfLeftLeaves(root.left, true) + SumOfLeftLeaves(root.right, false);
        
    }
    
    private int SumOfLeftLeaves(TreeNode node, bool isLeft)
    {
        if(node == null) return 0;
        if(node.left == null && node.right == null && isLeft){
            return node.val;
        }
        
        return SumOfLeftLeaves(node.left, true) + SumOfLeftLeaves(node.right, false);
    }
}