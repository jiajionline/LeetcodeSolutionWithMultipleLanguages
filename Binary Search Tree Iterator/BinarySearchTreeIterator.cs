using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    public class BSTIterator
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        public BSTIterator(TreeNode root)
        {
            AddAllLeftNodes(root);
        }

        /** @return whether we have a next smallest number */
        public bool HasNext()
        {
            return stack.Count > 0;
        }

        /** @return the next smallest number */
        public int Next()
        {
            var current = stack.Pop();
            AddAllLeftNodes(current.right);
            return current.val;
        }

        private void AddAllLeftNodes(TreeNode node)
        {
            var current = node;
            while (current != null)
            {
                stack.Push(current);
                current = current.left;
            }
        }
    }
}
