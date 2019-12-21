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
    private int cnt = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return cnt;
    }

    private void traverse(TreeNode node){
        if(node == null) return;
        if(node.left!=null && node.left.left == null && node.left.right == null){
            cnt += node.left.val;
        }
        traverse(node.left);
        traverse(node.right);
    }
}