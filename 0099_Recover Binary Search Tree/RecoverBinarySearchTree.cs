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
    public void RecoverTree(TreeNode root) {
        if(root == null) return;
        var stack = new Stack<TreeNode>();
        TreeNode prev = new TreeNode(int.MinValue);
        TreeNode firstNode = null;
        TreeNode secondNode = null;

        while(root!=null || stack.Count > 0)
        {
            while(root!=null){
                stack.Push(root);
                root = root.left;
            }
            
            root = stack.Pop();
            
            if(firstNode == null && prev.val > root.val){
                firstNode = prev;
            }

            if(firstNode!=null && root.val < prev.val){
                secondNode = root;
            }

            prev = root;
            
            root = root.right;
        }
        
        int tmpVal = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmpVal;
    }
}