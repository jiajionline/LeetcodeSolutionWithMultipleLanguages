/**
* Definition for a binary tree node.
* public class TreeNode {
*     public int val;
*     public TreeNode left;
*     public TreeNode right;
*     public TreeNode(int x) { val = x; }
* }
*/
public class Solution {
   public int SumNumbers(TreeNode root) {
        var sum = 0;
       if(root == null) return sum;
        var queue = new Queue<Tuple<TreeNode,int>>();
        queue.Enqueue(new Tuple<TreeNode,int>(root, root.val));

        while(queue.Count()>0)
        {
            var tmp = queue.Dequeue();
            var tmpNode = tmp.Item1;
            var tmpValue = tmp.Item2;
            if(tmpNode.left == null && tmpNode.right == null)
            {
                sum += tmpValue;
            }

            if(tmpNode.left!=null)
            {
                queue.Enqueue(new Tuple<TreeNode,int>(tmpNode.left, tmpValue* 10 + tmpNode.left.val));
            }

            if(tmpNode.right!=null)
            {
                queue.Enqueue(new Tuple<TreeNode,int>(tmpNode.right, tmpValue * 10 + tmpNode.right.val));
            }
        }
      
       return sum;
   }
}
