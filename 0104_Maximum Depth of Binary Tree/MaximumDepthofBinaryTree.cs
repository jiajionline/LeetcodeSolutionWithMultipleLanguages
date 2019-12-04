using System;

namespace LeetcodePracticeCsharpVersion
{
    class MaximumDepthofBinaryTree
    {
        public int MaxDepth(TreeNode root)
        {
            if (root == null) return 0;
            else
            {
                return Math.Max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
            }
        }
    }    
}
