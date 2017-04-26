using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class SymmetricTree
    {
        public bool IsSymmetric(TreeNode root)
        {
            return IsSame(root, root);
        }

        private bool IsSame(TreeNode left, TreeNode right)
        {
            if (left == null && right == null) return true;
            if (left !=null && right != null)
            {
                return left.val == right.val && IsSame(left.right, right.left) && IsSame(left.left, right.right);
            }

            return false;
        }

        public bool IsSymmetricIteration(TreeNode root)
        {
            if (root == null) return true;
            var queue = new Queue<TreeNode>();

            queue.Enqueue(root);
            queue.Enqueue(root);

            while(queue.Count >0)
            {
                var left = queue.Dequeue();
                var right = queue.Dequeue();

                if (left == null && right == null) continue;
                if (left == null || right == null) return false;

                if(left.val == right.val)
                {
                    queue.Enqueue(left.left);
                    queue.Enqueue(right.right);

                    queue.Enqueue(left.right);
                    queue.Enqueue(right.left);
                }
                else
                {
                    return false;
                }
            }

            return true;
        }
    }
}
