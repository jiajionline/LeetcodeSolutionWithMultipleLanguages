class Solution
{
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
}

