using System;

namespace LeetcodePracticeCsharpVersion
{
    class BalancedBinaryTree
    {
        public bool IsBalanced(TreeNode root)
        {
            return CheckBalance(root) != -1;
        }

        private int CheckBalance(TreeNode node)
        {
            if (node == null) return 0;
            int left = CheckBalance(node.left);
            if (left == -1) return -1;
            int right = CheckBalance(node.right);
            if (right == -1) return -1;
            if (Math.Abs(left - right) > 1) return -1;
            return Math.Max(left, right) + 1;
        }
        
    }
}
