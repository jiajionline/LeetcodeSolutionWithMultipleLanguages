using System;
using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class FindLargestValueinEachTreeRow
    {
        public IList<int> LargestValues(TreeNode root)
        {
            var currentLargestValueDict = new Dictionary<int, int>();
            DFS(root, 1, currentLargestValueDict);

            var ret = new List<int>(currentLargestValueDict.Count);

            for(int i = 0; i < currentLargestValueDict.Count; i++)
            {
                ret.Add(currentLargestValueDict[i + 1]);
            }

            return ret;
        }

        private void DFS(TreeNode node, int level, IDictionary<int, int> largestValueDict)
        {
            if (node == null) return;
            var value = node.val;
            if (largestValueDict.ContainsKey(level))
            {
                largestValueDict[level] = Math.Max(value, largestValueDict[level]);
            }
            else
            {
                largestValueDict.Add(level, value);
            }

            DFS(node.left, level + 1, largestValueDict);
            DFS(node.right, level + 1, largestValueDict);
        }
    }
}
