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
    public IList<IList<int>> FindLeaves(TreeNode root) {
        var ans = new List<IList<int>>();
        Height(root, ans);
        return ans;
    }
    
    private int Height(TreeNode node, IList<IList<int>> ans)
    {
        if(node == null) return -1;
        var height = 0;
        height = Math.Max(Height(node.left, ans), Height(node.right, ans)) + 1;
        if(ans.Count == height)
            ans.Add(new List<int>());
        ans[height].Add(node.val);
        return height;
    }
}