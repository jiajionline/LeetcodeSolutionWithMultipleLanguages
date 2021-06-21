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
    public int SumOfLeftLeaves(TreeNode root) {
        Traverse(root.left, true);
        Traverse(root.right, false);
        return ans;
        
    }
    
    public void Traverse(TreeNode node, bool isLeft) {
        if(node == null) return;
        if(isLeft && node.left == null && node.right == null) ans += node.val;
        Traverse(node.left, true);
        Traverse(node.right, false);
    }
}