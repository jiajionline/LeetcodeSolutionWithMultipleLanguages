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
    private TreeNode pre = null;
    private int ans = int.MaxValue;
    public int GetMinimumDifference(TreeNode root) {
        Traverse(root);
        return ans;
    }
    
    private void Traverse(TreeNode node){
        if(node == null) return;
        Traverse(node.left);
        if(pre != null){
            ans = Math.Min(ans, node.val - pre.val);
        }
        
        pre = node;
        Traverse(node.right);
    }
}