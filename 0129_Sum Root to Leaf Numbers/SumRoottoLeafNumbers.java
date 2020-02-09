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
    private int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root,0);
        return totalSum;
    }
    
    private void traverse(TreeNode node, int currentSum){
        if(node == null) return;
        currentSum = currentSum * 10 + node.val;
        if(node.left == null && node.right == null){
            totalSum += currentSum;
        }
        
        traverse(node.left, currentSum);
        traverse(node.right, currentSum);
    }
}