public class Solution {
    public bool IsCompleteTree(TreeNode root) {
        if(root == null) return true;
        
        var queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        var missing = false;
        
        while(queue.Count > 0)
        {
            var size = queue.Count;
            while(size-- > 0)
            {
                var node = queue.Dequeue();    
                if(node == null)
                {
                    missing = true;
                }
                else
                {
                    if(missing) return false;
                    queue.Enqueue(node.left);
                    queue.Enqueue(node.right);
                }
            }
        }
        
        return true;
    }
}