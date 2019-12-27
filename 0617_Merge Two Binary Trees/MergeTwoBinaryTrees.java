/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        int val = 0;
        if(t1 != null) val += t1.val;
        if(t2 != null) val += t2.val;
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(t1 == null? null : t1.left , t2 == null? null : t2.left);
        node.right = mergeTrees(t1 == null? null : t1.right , t2 == null? null : t2.right);
        return node;       
    }
}