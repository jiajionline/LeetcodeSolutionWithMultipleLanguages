public class Solution {
    public IList<TreeNode> AllPossibleFBT(int n) {
        var ans = new List<TreeNode>();
        if(n % 2 == 0) return ans;
        if(n == 1)
        {
            ans.Add(new TreeNode(0));
            return ans;
        }
        
        for (int i = 1; i < n; i += 2) {
          foreach (var l in AllPossibleFBT(i))
            foreach (var r in AllPossibleFBT(n - i - 1)) {
                var root = new TreeNode(0);
                root.left = l;
                root.right = r;
                ans.Add(root);
            }          
        }
        return ans;
    }
}