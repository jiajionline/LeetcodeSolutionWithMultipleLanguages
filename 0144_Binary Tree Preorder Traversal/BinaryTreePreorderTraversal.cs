public class Solution {
    public IList<int> PreorderTraversal (TreeNode root) {
        IList<int> ret = new List<int> ();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.Push (root);
        while (stack.Count () > 0) {
            var node = stack.Pop ();
            ret.Add (node.val);
            if (node.right != null) stack.Push (node.right);
            if (node.left != null) stack.Push (node.left);
        }

        return ret;
    }
}