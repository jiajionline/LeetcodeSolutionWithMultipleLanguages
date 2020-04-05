class Solution
{
    ///<summary>
    /// Iteration
    /// </summary>
    public int FindBottomLeftValue(TreeNode root)
    {
        var queue = new Queue<TreeNode>();
        TreeNode mostLeft = null;
        queue.Enqueue(root);

        while(queue.Count > 0)
        {
            mostLeft = queue.Dequeue();
            if (mostLeft.right != null) queue.Enqueue(mostLeft.right);
            if (mostLeft.left != null) queue.Enqueue(mostLeft.left);
        }

        return mostLeft.val;
    }

    ///<summary>
    /// Recursion
    ///</summary>        
    public int FindBottomLeftValueRecursion(TreeNode root)
    {
        var levelToLeftValueDict = new Dictionary<int, int>();
        LevelTraverse(root, 1, levelToLeftValueDict);
        return levelToLeftValueDict[levelToLeftValueDict.Count];
    }

    private void LevelTraverse(TreeNode node, int level, IDictionary<int,int> levelToLeftValueDict)
    {
        if (node == null) return;
        if (!levelToLeftValueDict.ContainsKey(level))
        {
            levelToLeftValueDict.Add(level, node.val);
        }

        LevelTraverse(node.left, level + 1,levelToLeftValueDict);
        LevelTraverse(node.right, level + 1, levelToLeftValueDict);
    }
}

