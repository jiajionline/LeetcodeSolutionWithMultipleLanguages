public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        var ans = new List<int>();
        var stack = new Stack<TreeNode>();
        var p = root;
        while(p!=null || stack.Count > 0)
        {
            if(p!=null)
            {
                stack.Push(p);
                p = p.left;
            }else{
                p = stack.Pop();
                ans.Add(p.val);
                p = p.right;
            }
        }
        
        return ans;
    }
}