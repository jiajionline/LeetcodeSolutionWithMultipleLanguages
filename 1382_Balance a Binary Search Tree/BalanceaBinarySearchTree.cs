public class Solution {
    public TreeNode BalanceBST(TreeNode root) {
        var list = new List<TreeNode>();
        Traverse(root, list);
        return Build(list, 0, list.Count - 1);
    }
    
    private void Traverse(TreeNode node, List<TreeNode> list)
    {
        if(node == null) return;
        Traverse(node.left, list);
        list.Add(node);
        Traverse(node.right, list);
    }
    
    private TreeNode Build(List<TreeNode> list, int l , int r)
    {
        if(l > r) return null;
        var mid = (r-l)/2 + l;
        var node = list[mid];
        node.left = Build(list, l , mid-1);
        node.right = Build(list, mid+1, r);
        return node;
    }
}