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
        var stack = new Stack<Tuple<TreeNode,int>>();
        stack.Push(new Tuple<TreeNode,int>(root, root.val));

        while(stack.Count()>0)
        {
            var tmp = stack.Pop();
            var tmpNode = tmp.Item1;
            var tmpValue = tmp.Item2;
            if(tmpNode.left == null && tmpNode.right == null)
            {
                sum += tmpValue;
            }

            if(tmpNode.left!=null)
            {
                stack.Push(new Tuple<TreeNode,int>(tmpNode.left, tmpValue* 10 + tmpNode.left.val));
            }

            if(tmpNode.right!=null)
            {
                stack.Push(new Tuple<TreeNode,int>(tmpNode.right, tmpValue * 10 + tmpNode.right.val));
            }
        }
      
       return sum;
   }
}
