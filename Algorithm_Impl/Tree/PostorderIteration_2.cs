public class Solution {
    public IList<int> PostorderTraversal(TreeNode root) {
        var ans = new List<int>();
        var stack = new Stack<TreeNode>();
        var p = root;
        
        while(p!=null || stack.Count > 0)
        {
            if(p!=null)
            {
                ans.Add(p.val);
                stack.Push(p);
                p = p.right;
            }else{
                p = stack.Pop();
                p = p.left;
            }
        }
        
        ans.Reverse();
        return ans;
    }
}