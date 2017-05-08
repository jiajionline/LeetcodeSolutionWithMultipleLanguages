using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class InvertBinaryTree
    {
        public TreeNode InvertTree(TreeNode root)
        {
            if (root == null) return root;
            var queue = new Queue<TreeNode>();
            queue.Enqueue(root);

            while(queue.Count > 0)
            {
                var node = queue.Dequeue();
                if (node.left != null || node.right != null)
                {
                    var temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    if(node.left != null)
                    {
                        queue.Enqueue(node.left);
                    }

                    if(node.right != null)
                    {
                        queue.Enqueue(node.right);
                    }                
                }                
            }

            return root;
        }
    }
}
