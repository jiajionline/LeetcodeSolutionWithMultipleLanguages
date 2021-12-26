public class Solution {
    public int CountNodes(TreeNode root) {
        if(root == null) return 0;
        var leftDepth = LeftDepth(root);
        var rightDepth = RightDepth(root);
        
        if(leftDepth == rightDepth)
        {
            return (1 << leftDepth) - 1;
        }else{
            return 1 + CountNodes(root.left) + CountNodes(root.right);
        }
    }
    
    private int LeftDepth(TreeNode node)
    {
        var depth = 0;
        while(node != null)
        {
            depth++;
            node = node.left;
        }
        
        return depth;
    }
    
    private int RightDepth(TreeNode node)
    {
        var depth = 0;
        while(node != null)
        {
            depth++;
            node = node.right;
        }
        
        return depth;
    }
}