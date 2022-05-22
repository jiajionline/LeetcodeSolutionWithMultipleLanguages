public class Solution {
    public IList<int> PreorderTraversal(TreeNode root) {
        var ans = new List<int>();
        TreeNode p = root;
        var stack = new Stack<TreeNode>();
        while(p!=null || stack.Count > 0)
        {
            if(p!=null)
            {
                ans.Add(p.val);
                stack.Push(p);
                p = p.left;
            }else{
                p = stack.Pop();
                p = node.right;
            }
        }
        
        return ans;
    }
}