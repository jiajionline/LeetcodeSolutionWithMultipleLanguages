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
    private int accumulatedVal = 0;
    public TreeNode BstToGst(TreeNode root) {
        PostOrder(root);
        return root;
    }
    
    private void PostOrder(TreeNode node){
        if(node == null) return;
        PostOrder(node.right);
        node.val += accumulatedVal;
        accumulatedVal = node.val;
        PostOrder(node.left);
    }
}