public class Solution {
   public bool HasPathSum(TreeNode root, int sum) {
       if(root == null) return false;
        var queue = new Queue<Tuple<TreeNode,int>>();
        queue.Enqueue(new Tuple<TreeNode,int>(root, root.val));

        while(queue.Count()>0)
        {
            var tmp = queue.Dequeue();
            var tmpNode = tmp.Item1;
            var tmpValue = tmp.Item2;
            if(tmpNode.left == null && tmpNode.right == null)
            {
                if(tmpValue == sum)
                    return true;
            }

            if(tmpNode.left!=null)
            {
                queue.Enqueue(new Tuple<TreeNode,int>(tmpNode.left, tmpValue + tmpNode.left.val));
            }

            if(tmpNode.right!=null)
            {
                queue.Enqueue(new Tuple<TreeNode,int>(tmpNode.right, tmpValue + tmpNode.right.val));
            }
        }
      
       return false;
   }
}
