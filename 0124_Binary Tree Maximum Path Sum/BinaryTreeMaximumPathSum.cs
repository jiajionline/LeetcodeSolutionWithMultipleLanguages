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
    private int ans = int.MinValue;
    public int MaxPathSum(TreeNode root) {
        Traverse(root);
        return ans;
    }
    
    private int Traverse(TreeNode node)
    {
        if(node == null) return 0;
        var left = Math.Max(0,Traverse(node.left));
        var right = Math.Max(0,Traverse(node.right));
        ans = Math.Max(ans, left + right + node.val);
        return Math.Max(left, right) + node.val;
    }
}