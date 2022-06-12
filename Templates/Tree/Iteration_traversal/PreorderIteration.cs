public class Solution {
    public IList<int> PreorderTraversal (TreeNode root) {
        var ans = new List<int> ();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.Push (root);
        while (stack.Count () > 0) {
            var node = stack.Pop ();
            ans.Add (node.val);
            if (node.right != null) stack.Push (node.right);
            if (node.left != null) stack.Push (node.left);
        }

        return ret;
    }
}
