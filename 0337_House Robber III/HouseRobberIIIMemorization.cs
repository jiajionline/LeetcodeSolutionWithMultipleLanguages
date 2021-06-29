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
    public int Rob(TreeNode root) {
        return Rob(root, new Dictionary<TreeNode, int>());
    }
    
    private int Rob(TreeNode node, Dictionary<TreeNode, int> dict)
    {
        if(node == null) return 0;
        if(dict.ContainsKey(node)) return dict[node];
        var v = node.val;
        var ll = node.left != null ? Rob(node.left.left, dict) : 0;
        var lr = node.left != null ? Rob(node.left.right, dict) : 0;
        var rl = node.right != null ? Rob(node.right.left, dict) : 0;
        var rr = node.right != null ? Rob(node.right.right, dict) : 0;
        var k = Math.Max(v + ll + lr + rl + rr, Rob(node.left, dict) + Rob(node.right, dict));
        dict.Add(node, k);
        return k;
    }
}