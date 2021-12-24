/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int s, int e)
    {
        if(s >= e) return null;
        TreeNode node = new TreeNode(preorder[s]);
        int m = s;
        while(m < e && preorder[m] <= node.val) m++;
        node.left = bstFromPreorder(preorder, s+1, m);
        node.right = bstFromPreorder(preorder, m, e);
        return node;
    }
}