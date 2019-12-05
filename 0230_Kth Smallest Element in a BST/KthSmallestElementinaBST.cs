/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    private int val = -1;
    private int searchCount = 0;

    public int KthSmallest(TreeNode root, int k){
        searchCount = k;
        Search(root);
        return val;
    }

    private void Search(TreeNode node){
        if (node == null || searchCount == 0) return;
        Search (node.left);

        searchCount--;
        if (searchCount == 0) {
            val = node.val;
            return;
        }
        Search(node.right);
    }
}