public class Solution {
    private int _ans = 0;
    private int _level = 0;
    public int FindBottomLeftValue(TreeNode root) {
        Traverse(root, 1);
        return _ans;
    }
    
    private void Traverse(TreeNode node, int level)
    {
        if(node == null) return;
        if(level > _level)
        {
            _level = level;
            _ans = node.val;
        }
        
        Traverse(node.left, level+1);
        Traverse(node.right, level + 1);
    }
}