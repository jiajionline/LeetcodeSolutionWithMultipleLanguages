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
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        LP(root);
        return ans;
    }

    private int LP(TreeNode node){
        if(node == null) return -1;
        int left = LP(node.left);
        int right = LP(node.right);
        //plus one means add the edge between it's direct child and itself
        int currentMax = Math.max(left, right) + 1;
        ans = Math.max(ans, (left + 1) + (right + 1));

        return currentMax;
    }

}