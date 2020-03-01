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
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return ans;
    }

    private int postOrder(TreeNode root) {
        if(root == null) return 0;
        //the subtree won't be included since the value of the sub tree is less than 0.
        int left = Math.max(0,postOrder(root.left));
        int right = Math.max(0,postOrder(root.right));
        //it must include itself plus left and right path
        ans = Math.max(ans, left + right + root.val);

        //return the max value of current node
        return Math.max(left, right) + root.val;
    }
}