using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class BinaryTreeLevelOrderTraversal
    {
        public IList<IList<int>> LevelOrder(TreeNode root)
        {
            IList<IList<int>> result = new List<IList<int>>();
            if (root == null) return result;

            Queue<TreeNode> currentLevel = new Queue<TreeNode>();
            Queue<TreeNode> nextLevel = new Queue<TreeNode>();

            currentLevel.Enqueue(root);

            while(currentLevel.Count > 0)
            {
                var currentLevelList = new List<int>();
                while(currentLevel.Count > 0)
                {
                    var node = currentLevel.Dequeue();
                    currentLevelList.Add(node.val);
                    if(node.left!=null)
                        nextLevel.Enqueue(node.left);
                    if (node.right != null)
                        nextLevel.Enqueue(node.right);
                }

                result.Add(currentLevelList);
                var tempQueue = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempQueue;
            }

            return result;
        }
    }
}
