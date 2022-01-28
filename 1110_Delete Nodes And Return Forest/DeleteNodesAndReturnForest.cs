public class Solution {
    public IList<TreeNode> DelNodes(TreeNode root, int[] to_delete) {
        var ans = new List<TreeNode>();
        var toDeleteSet = new HashSet<int>(to_delete);
        var node = Traverse(root, ans, toDeleteSet);
        if(node != null) ans.Add(node);
        return ans;
    }
    
    private TreeNode Traverse(TreeNode node, IList<TreeNode> ans, HashSet<int> toDeleteSet)
    {
        if(node == null) return null;
        node.left = Traverse(node.left, ans, toDeleteSet);
        node.right = Traverse(node.right, ans, toDeleteSet);
        
        if(toDeleteSet.Contains(node.val))
        {
            if(node.left != null) ans.Add(node.left);
            if(node.right != null) ans.Add(node.right);
            return null;
        }else
            return node;
    }
}