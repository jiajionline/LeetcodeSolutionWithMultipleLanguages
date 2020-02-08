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
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private TreeNode first = null;
    private TreeNode second = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int v = first.val;
        first.val = second.val;
        second.val = v;
    }

    private void traverse(TreeNode node){
        if(node == null) return;
        traverse(node.left);
        if(first == null && prev.val > node.val){
            first = prev;
        }

        if(first !=null && node.val < prev.val){
            second = node;
        }

        prev = node;
        traverse(node.right);
    }
}