public class Solution {
    public IList<int> PostorderTraversal(TreeNode root) {
        var list = new List<int>();
        if(root == null) return list;
        var stack = new Stack<TreeNode>();
        stack.Push(root);
        while(stack.Count > 0)
        {
            var node = stack.Pop();
            list.Insert(0, node.val);
            if(node.left!=null) stack.Push(node.left);
            if(node.right!=null) stack.Push(node.right);
        }
        
        list.Reverse();
        return list;
    }
}