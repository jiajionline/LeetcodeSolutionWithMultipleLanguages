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
    private int ans = 0;
    public int maxSumBST(TreeNode root) {
        DFS(root);
        return ans;
    }
    
    private Item DFS(TreeNode node) {
        if(node == null) return new Item(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        Item left = DFS(node.left);
        Item right = DFS(node.right);
        boolean isBST = left.isBST && right.isBST && node.val > left.rVal && node.val < right.lVal;
        int sum = isBST ? left.sum + right.sum + node.val : -1;
        ans = Math.max(ans, sum);
        return new Item(Math.min(left.lVal, node.val), Math.max(right.rVal, node.val), sum, isBST);
    }
    
    private class Item {
        int lVal;
        int rVal;
        int sum;
        boolean isBST;
        
        public Item(int v1, int v2, int v3, boolean v4) {
            lVal = v1;
            rVal = v2;
            sum  = v3;
            isBST = v4;
        }
    }
}