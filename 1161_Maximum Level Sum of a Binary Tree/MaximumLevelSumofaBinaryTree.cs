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
    public int MaxLevelSum(TreeNode root) {
        var maxSum = int.MinValue;
        var maxSumLevel = 0;
        var queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        var level = 0;
        while(queue.Count > 0)
        {
            level++;
            var sum = 0;
            var count = queue.Count;
            while(count-- > 0)
            {
                var node = queue.Dequeue();
                if(node.left!=null) queue.Enqueue(node.left);
                if(node.right!=null) queue.Enqueue(node.right);
                
                sum += node.val;
            }
            
            if(maxSum < sum)
            {
                maxSum = sum;
                maxSumLevel = level;
            }
        }
        
        return maxSumLevel;
    }
}