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
    public int DistributeCoins(TreeNode root) {
        Balance(root);
        return ans;
    }
    
    private int Balance(TreeNode node)
    {
        if(node == null) return 0;
        int l = Balance(node.left);
        int r = Balance(node.right);
        ans += Math.Abs(l) + Math.Abs(r);
        return l + r + node.val - 1;
    }
}