/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;
        getMinimumDifference(root.left);
        
        if(prev!=null){
            min = Math.min(min,root.val - prev.val);
        }
        
        prev = root;
        
        getMinimumDifference(root.right);
        return min;
    }
}