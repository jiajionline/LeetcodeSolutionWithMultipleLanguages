/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private int min;
    private long ans = long.MaxValue;

    public int FindSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        min = root.val;
        DFS(root);
        return ans > int.MaxValue ? -1 : (int)ans;
    }

    private void DFS(TreeNode node){
        if(node == null) return;
        if(node.val>min && node.val < ans){
            ans = node.val;
        }else if(node.val == min){
            DFS(node.left);
            DFS(node.right);
        }
        
    }
}