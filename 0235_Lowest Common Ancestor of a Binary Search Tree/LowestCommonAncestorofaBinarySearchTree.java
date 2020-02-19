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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = p.val < q.val ? p : q;
        TreeNode right = p.val > q.val ? p : q;
        return common(root, left, right);
    }
    
    private TreeNode common(TreeNode node, TreeNode left, TreeNode right){
        if(node == left || node == right) return node;
        
        if(left.val < node.val && right.val > node.val){
            return node;
        }else if(left.val < node.val && right.val < node.val){
            return common(node.left, left, right);    
        }else{
            return common(node.right, left, right);
        }
    }
}