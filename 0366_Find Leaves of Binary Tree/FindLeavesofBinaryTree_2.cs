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
        var preRoot = new TreeNode(0);
        preRoot.left = root;
        
        while(preRoot.left!=null)
        {
            var list = new List<int>();
            Remove(preRoot, list);
            ans.Add(list);
        }
        
        return ans;
    }
    
    private bool Remove(TreeNode node, List<int> list)
    {
        if(node == null) return true;
        if(node.left == null && node.right == null)
        {
            list.Add(node.val);
            return true;
        }
        
        var left = Remove(node.left, list);
        if(left) node.left = null;
        var right = Remove(node.right, list);
        if(right) node.right = null;
        return false;
    }
}