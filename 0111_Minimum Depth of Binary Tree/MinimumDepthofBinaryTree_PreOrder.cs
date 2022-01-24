public class Solution {
    private int ans = int.MaxValue;
    public int MinDepth(TreeNode root) {
        if(root == null) return 0;
        Depth(root,1);
        return ans;
    }
    
    private void Depth(TreeNode node, int depth)
    {
        if(node == null) return;
        if(node.left == null && node.right == null)
            ans = Math.Min(ans, depth);
        
        Depth(node.left, depth+1);
        Depth(node.right, depth+1);
    }
}