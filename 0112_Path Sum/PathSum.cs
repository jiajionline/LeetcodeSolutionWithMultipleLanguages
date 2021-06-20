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
    public bool HasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        var queue = new Queue<Tuple<TreeNode,int>>();
        queue.Enqueue(new Tuple<TreeNode,int>(root, targetSum));
        
        while(queue.Count > 0)
        {
            var v = queue.Dequeue();
            var node = v.Item1;
            var sum = v.Item2;
            if(node.left == null && node.right == null && sum == node.val) return true;
            if(node.left != null)
                queue.Enqueue(new Tuple<TreeNode, int>(node.left, sum - node.val));
            
            if(node.right != null)
                queue.Enqueue(new Tuple<TreeNode, int>(node.right, sum - node.val));
        }
        
        return false;
    }
}