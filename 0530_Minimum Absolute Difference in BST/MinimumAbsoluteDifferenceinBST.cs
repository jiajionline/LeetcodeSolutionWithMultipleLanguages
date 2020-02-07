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
    public int GetMinimumDifference(TreeNode root) {
        var min = int.MaxValue;
        if(root == null) return min;
        
        
        var stack = new Stack<TreeNode>();
        TreeNode prev = null;
        
        while(root!=null || stack.Count()>0){
            while(root!=null){
                stack.Push(root);
                root = root.left;
            }
            
            root = stack.Pop();
            if(prev!=null){
                min = Math.Min(root.val - prev.val,min);
            }
            
            prev = root;
            root = root.right;
        }
        
        return min;
    }
}