public class Solution {
    public TreeNode SubtreeWithAllDeepest(TreeNode root) {
        return Deep(root).Item1;
    }
    
    private Tuple<TreeNode,int> Deep(TreeNode node)
    {
        if(node == null)
        {
            TreeNode nullNode = null;
            return Tuple.Create(nullNode, 0);
        }
            
        var l = Deep(node.left);
        var r = Deep(node.right);
        
        if(l.Item2 == r.Item2)
            return Tuple.Create(node, l.Item2 + 1);
        else if(l.Item2 > r.Item2)
            return Tuple.Create(l.Item1, l.Item2 + 1);
        else
            return Tuple.Create(r.Item1, r.Item2 + 1);
    }
}