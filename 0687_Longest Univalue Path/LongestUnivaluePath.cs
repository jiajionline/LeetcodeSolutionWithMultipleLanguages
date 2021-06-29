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
    private int ans = 0;
    public int LongestUnivaluePath(TreeNode root) {
        Traverse(root);
        return ans;
    }
    
    // return current val & it's depth with the same val
    private int Traverse(TreeNode node)
    {
        if(node == null) return 0;
        var left = Traverse(node.left);
        var right = Traverse(node.right);
        
        var l = 0;
        var r = 0;
        if(node.left != null && node.val == node.left.val)
        {
            l += left;
        }
        
        if(node.right != null && node.val == node.right.val)
        {
            r += right;
        }
        
        ans = Math.Max(ans, l + r);
        
        return Math.Max(l,r) + 1;
    }
}