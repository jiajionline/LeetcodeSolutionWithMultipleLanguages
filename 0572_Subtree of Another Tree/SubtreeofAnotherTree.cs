public class Solution {
   public bool IsSubtree(TreeNode s, TreeNode t) {
       var queue = new Queue<TreeNode>();
        queue.Enqueue(s);

        while(queue.Count > 0)
        {
            var node = queue.Dequeue();
            if(!IsSameTree(node, t))
            {
                if(node.left !=null) queue.Enqueue(node.left);
                if(node.right !=null) queue.Enqueue(node.right);
            }else{
                return true;
            }
        }

        return false;
   }

    private bool IsSameTree(TreeNode s, TreeNode t)
    {
        if(s == null && t == null) return true;
        if(s!=null && t!=null && s.val == t.val){
            return IsSameTree(s.left, t.left) && IsSameTree(s.right, t.right);
        }else{
            return false;
        }
    }
}
