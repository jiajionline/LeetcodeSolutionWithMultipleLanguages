using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class MergeTwoBinaryTrees
    {
        public TreeNode MergeTrees(TreeNode t1, TreeNode t2)
        {
            if (t1 == null && t2 == null) return null;
            int value = 0;
            if (t1 != null) value += t1.val;
            if (t2 != null) value += t2.val;

            TreeNode node = new TreeNode(value);
            node.left = MergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            node.right = MergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

            return node;
        }
    }
}
