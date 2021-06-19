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
    public int MaxDepth(TreeNode root) {
        if(root == null) return 0;
        var stack = new Stack<Tuple<TreeNode, int>>();
        stack.Push(new Tuple<TreeNode, int>(root, 1));
        var max = 0;
        while(stack.Count > 0)
        {
            var tup = stack.Pop();
            max = Math.Max(max, tup.Item2);
            
            if(tup.Item1.left != null) stack.Push(new Tuple<TreeNode, int>(tup.Item1.left, tup.Item2+1));
            
            if(tup.Item1.right != null) stack.Push(new Tuple<TreeNode, int>(tup.Item1.right, tup.Item2+1));
        }
        
        return max;
    }
}