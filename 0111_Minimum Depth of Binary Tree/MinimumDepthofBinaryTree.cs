public class Solution {
    public int MinDepth(TreeNode root) {
        if(root == null) return 0;
        var queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        
        var level = 0;
        while(queue.Count > 0)
        {
            level++;
            var c = queue.Count;
            while(c-- > 0)
            {
                var n = queue.Dequeue();
                if(n.left == null && n.right == null) return level;
                if(n.left!=null) queue.Enqueue(n.left);
                if(n.right!=null) queue.Enqueue(n.right);
            }
        }
        
        return -1;
    }
}