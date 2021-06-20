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
    private int ans = 0;
    public int SumNumbers(TreeNode root) {
        Traverse(root, 0);
        return ans;
    }
    
    private void Traverse(TreeNode node, int v)
    {
        if(node == null) return;
        v *= 10;
        v += node.val;
        if(node.left == null && node.right == null){
            ans += v;
        }
        
        Traverse(node.left, v);
        Traverse(node.right, v);
       
    }
}