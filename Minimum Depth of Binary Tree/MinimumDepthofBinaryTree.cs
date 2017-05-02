using System;

namespace LeetcodePracticeCsharpVersion
{
    class MinimumDepthofBinaryTree
    {
        public int MinDepth(TreeNode root)
        {
            if (root == null) return 0;
            int left = MinDepth(root.left);
            int right = MinDepth(root.right);

            return (left == 0 || right == 0) ? left + right + 1 : Math.Min(left, right) + 1;
        }
    }
}
