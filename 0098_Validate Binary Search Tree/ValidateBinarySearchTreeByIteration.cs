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
    public bool IsValidBST(TreeNode root) {
        if(root == null) return true;
        var stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root!=null || stack.Count > 0)
        {
            while(root!=null){
                stack.Push(root);
                root = root.left;
            }
            
            root = stack.Pop();
            if(pre!=null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        
        return true;
    }
}