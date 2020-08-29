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
    public int MaxSumBST(TreeNode root) {
        DFS(root);
        return ans;
    }

    private Tuple<int,int,int,bool> DFS(TreeNode node){
        if(node == null) return Tuple.Create<int,int,int,bool>(int.MaxValue, int.MinValue, 0,true);
        var left = DFS(node.left);
        var right = DFS(node.right);
        var valid = left.Item4 && right.Item4 && node.val > left.Item2  && node.val < right.Item1;
        int sum = valid ? left.Item3 + right.Item3 + node.val : -1;
        ans = Math.Max(ans, sum);
        
        return Tuple.Create<int,int,int,bool>(Math.Min(left.Item1, node.val), Math.Max(right.Item2, node.val), sum, valid);
    }
}
